package pl.justitia.ingester.service.impl;

import feign.FeignException;
import feign.codec.DecodeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.justitia.ingester.model.ApiResponse;
import pl.justitia.ingester.model.Link;
import pl.justitia.ingester.rest.SaosClient;
import pl.justitia.ingester.service.FileService;
import pl.justitia.ingester.service.JudgmentDownloadService;

import java.awt.event.WindowFocusListener;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Service
public class JudgmentDownloadServiceImpl implements JudgmentDownloadService {

    private final SaosClient saosClient;
    private final FileService fileService;

    public JudgmentDownloadServiceImpl(SaosClient saosClient, FileService fileService) {
        this.saosClient = saosClient;
        this.fileService = fileService;
    }

    @Override
    public void getJudgments(int pageSize, int pageNumber) {
        boolean hasNextPage = true;
        int retryAttempts = 0;  // Liczba prób ponowienia zapytania
        int retryDelay = 300000; // 5 minut (300000 ms)
        int maxRetries = 12;

        while (hasNextPage) {
            try {
                Thread.sleep(1000);  // Chwila przerwy pomiędzy zapytaniami
            } catch (InterruptedException e) {
                log.error("Error during thread sleep.");
                throw new RuntimeException(e);
            }

            log.info("Downloading pageSize: {} and pageNumber {}", pageSize, pageNumber);

            try {
                ResponseEntity<ApiResponse> response = saosClient.getJudgments(pageSize, pageNumber);

                if (response.getStatusCode().equals(HttpStatus.OK)) {
                    ApiResponse apiResponse = response.getBody();

                    if (apiResponse != null && apiResponse.getItems() != null) {
                        apiResponse.getItems().forEach(fileService::saveItem);

                        Optional<Link> next = apiResponse.getLinks().stream().filter(link -> "next".equals(link.getRel())).findFirst();
                        if (next.isPresent()) {
                            // Jeśli jest następna strona, pobieramy dane z URL i przechodzimy do kolejnej strony
                            String nextUrl = next.get().getHref();
                            Map<String, String> params = extractParams(nextUrl);
                            pageSize = Integer.parseInt(params.get("pageSize"));
                            pageNumber = Integer.parseInt(params.get("pageNumber"));
                        } else {
                            // Jeśli nie ma kolejnej strony, kończymy pętlę
                            log.info("---------------------It was last judgment-------------------------");
                            hasNextPage = false;
                        }
                    } else {
                        log.error("Error during /judgment API call. Response is empty.");
                        hasNextPage = false;  // Kończymy pętlę, gdy nie ma elementów do pobrania
                    }
                } else {
                    log.error("Response HTTP status code != 200");
                    throw new RuntimeException("API call failed");
                }
            } catch (FeignException e) {
                if (e instanceof DecodeException) {
                    log.error("DecodeException: Received HTML response, possibly due to server downtime. Retrying in 10 minutes...");
                    retryAttempts++;

                    if (retryAttempts >= maxRetries) {
                        log.error("Max retry attempts reached. Stopping further requests.");
                        break;  // Kończy pętlę po 3 próbach
                    }

                    // Czekamy 10 minut przed ponowną próbą
                    try {
                        Thread.sleep(600000);  // Czekamy 10 minut (600,000 ms)
                    } catch (InterruptedException ex) {
                        log.error("Error during retry sleep.");
                        throw new RuntimeException(ex);
                    }
                } else if (e.getCause() instanceof SocketTimeoutException) {
                    // Obsługuje sytuację, gdy występuje SocketTimeoutException (Read timed out)
                    log.error("SocketTimeoutException: Read timed out. Retrying in 5 minutes...");
                    retryAttempts++;

                    if (retryAttempts >= maxRetries) {
                        log.error("Max retry attempts reached. Stopping further requests.");
                        break;  // Kończy pętlę po 3 próbach
                    }

                    // Czekamy 5 minut przed ponowną próbą
                    try {
                        Thread.sleep(retryDelay);  // Czekamy 5 minut (300,000 ms)
                    } catch (InterruptedException ex) {
                        log.error("Error during retry sleep.");
                        throw new RuntimeException(ex);
                    }
                } else {
                    // Inne wyjątki (np. FeignException, UnknownHostException)
                    log.error("Error during API call: {}", e.getMessage());
                    throw new RuntimeException(e);
                }
            }
        }
    }





    private Map<String, String> extractParams(String url) {
        URI uri;
        try {
            uri = new URI(url);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        String query = uri.getQuery();

        String[] params = query.split("&");
        Map<String, String> queryParams = new HashMap<>();
        for (String param : params) {
            String[] keyValue = param.split("=");
            queryParams.put(keyValue[0], keyValue[1]);
        }
        return queryParams;
    }
}
