package pl.medrekkaszuba.service;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.medrekkaszuba.model.api.LatestNewsRequest;
import pl.medrekkaszuba.model.api.NewsResponse;


@Slf4j
@Component
public class NewsAPIClient {

    private final NewsApi newsApi;

    public NewsAPIClient(NewsApi newsApi) {
        this.newsApi = newsApi;
    }


    public NewsResponse getTweets(LatestNewsRequest request) {
        try {
            return newsApi.getNews(request.getLanguage());
        } catch (FeignException e) {
            log.error("[NewsAPIClient] An error has been occurred during GET request to News API: {}", e.request());
        }
        return null;
    }
}
