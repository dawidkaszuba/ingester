package pl.medrekkaszuba.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.medrekkaszuba.model.Image;
import pl.medrekkaszuba.model.NewsItem;
import pl.medrekkaszuba.model.api.LatestNewsRequest;
import pl.medrekkaszuba.model.api.NewsResponse;
import pl.medrekkaszuba.publisher.KafkaPublisherService;
import pl.medrekkaszuba.repository.NewsRepository;
import pl.medrekkaszuba.service.NewsAPIClient;
import pl.medrekkaszuba.service.NewsService;

import java.util.List;

@Slf4j
@Service
public class NewsServiceImpl implements NewsService {


    private final NewsAPIClient newsApiClient;
    private final KafkaPublisherService kafkaPublisherService;

    private final NewsRepository newsRepository;
    // sprawdzic czy nie lepiej tu powinien byc serowis uzywajacy repozytorium

    public NewsServiceImpl(NewsAPIClient newsApiClient, KafkaPublisherService kafkaPublisherService, NewsRepository newsRepository) {
        this.newsApiClient = newsApiClient;
        this.kafkaPublisherService = kafkaPublisherService;
        this.newsRepository = newsRepository;
    }

    @Override
    public void processNews(LatestNewsRequest request) {

        NewsResponse response = newsApiClient.getTweets(request);

        if (response != null && response.getNews() != null && !response.getNews().isEmpty()) {
            saveRetrievedData(response.getNews());
            sendToKafka(response.getNews());
        }
    }

    private void saveRetrievedData(List<NewsItem> news) {
        news.forEach(newsRepository::save);
    }

    private void sendToKafka(List<NewsItem> news) {
        news.forEach(newsItem -> {
            if(newsItem.getImage() != null && newsItem.getDbId() != null) {
                Image image = new Image(newsItem.getImage(), newsItem.getNewsItemId());
                kafkaPublisherService.sendImageToProcess(image);
            }
        });
    }

}
