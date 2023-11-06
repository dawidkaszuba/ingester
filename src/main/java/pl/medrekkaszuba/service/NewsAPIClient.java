package pl.medrekkaszuba.service;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.medrekkaszuba.model.api.LatestNewsRequest;
import pl.medrekkaszuba.model.api.NewsResponse;
import pl.medrekkaszuba.model.api.SearchNewsRequest;


@Slf4j
@Component
public class NewsAPIClient {

    private final NewsApi newsApi;

    public NewsAPIClient(NewsApi newsApi) {
        this.newsApi = newsApi;
    }


    public NewsResponse getNews(LatestNewsRequest request) {
        try {
            return newsApi.getNews(request.getLanguage());
        } catch (FeignException e) {
            log.error("[NewsAPIClient] An error has been occurred during GET request to News API: {}", e.request());
        }
        return null;
    }

    public NewsResponse searchNews(SearchNewsRequest request) {
        try {
            return newsApi.searchNews(request.getLanguage(), request.getKeywords(), request.getCountry(), request.getCategory(), request.getStartDate(), request.getEndDate());
        } catch (FeignException e) {
            log.error("[NewsAPIClient] An error has been occurred during GET request to News API: {}", e.request());
        }
        return null;
    }
}
