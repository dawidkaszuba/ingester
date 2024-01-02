package pl.medrekkaszuba.ingester.service;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.medrekkaszuba.ingester.model.api.LatestNewsRequest;
import pl.medrekkaszuba.ingester.model.api.NewsResponse;
import pl.medrekkaszuba.ingester.model.api.SearchNewsRequest;

import java.util.LinkedHashMap;
import java.util.Map;


@Slf4j
@Component
public class NewsAPIClient {

    private final NewsApi newsApi;

    public NewsAPIClient(NewsApi newsApi) {
        this.newsApi = newsApi;
    }


    public NewsResponse getNews(LatestNewsRequest request) {
        try {
            Map<String, String> parameters = new LinkedHashMap<>();
            parameters.put("language", request.getLanguage());
            return newsApi.getNews(parameters);
        } catch (FeignException e) {
            log.error("[NewsAPIClient] An error has been occurred during GET request to News API: {}", e.request());
        }
        return null;
    }

    public NewsResponse searchNews(SearchNewsRequest request) {
        try {
            Map<String, String> parameters = new LinkedHashMap<>();
            parameters.put("language", request.getLanguage());
            parameters.put("keywords", request.getKeywords());
            parameters.put("category", request.getCategory());
            parameters.put("country", request.getCountry());
            parameters.put("startDate", request.getStartDate().toString());
            parameters.put("endDate", request.getEndDate().toString());
            parameters.put("limit", request.getLimit().toString());
            parameters.put("page_size", request.getPageSize().toString());
            parameters.put("page_number", request.getPageNumber().toString());

            return newsApi.searchNews(parameters);
        } catch (FeignException e) {
            log.error("[NewsAPIClient] An error has been occurred during GET request to News API: {}", e);
        }
        return null;
    }
}
