package pl.medrekkaszuba.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.medrekkaszuba.dao.NewsDao;
import pl.medrekkaszuba.model.ImageDto;
import pl.medrekkaszuba.model.NewsItemDto;
import pl.medrekkaszuba.model.api.LatestNewsRequest;
import pl.medrekkaszuba.model.api.NewsResponse;
import pl.medrekkaszuba.model.api.SearchNewsRequest;
import pl.medrekkaszuba.publisher.KafkaPublisherService;
import pl.medrekkaszuba.service.NewsAPIClient;
import pl.medrekkaszuba.service.NewsService;

import java.util.List;

@Slf4j
@Service
public class NewsServiceImpl implements NewsService {


    private final NewsAPIClient newsApiClient;
    private final KafkaPublisherService kafkaPublisherService;
    private final NewsDao newsDao;

    public NewsServiceImpl(NewsAPIClient newsApiClient, KafkaPublisherService kafkaPublisherService, NewsDao newsDao) {
        this.newsApiClient = newsApiClient;
        this.kafkaPublisherService = kafkaPublisherService;
        this.newsDao = newsDao;
    }

    @Override
    public void getLatestNews(LatestNewsRequest request) {
        NewsResponse response = newsApiClient.getNews(request);
        processNews(response);
    }

    @Override
    public void searchNews(SearchNewsRequest request) {
        NewsResponse response = newsApiClient.searchNews(request);
        processNews(response);
    }

    private void processNews(NewsResponse response) {
        if (response != null && response.getNews() != null && !response.getNews().isEmpty()) {
            saveRetrievedData(response.getNews());
            sendToKafka(response.getNews());
        }
    }

    private void saveRetrievedData(List<NewsItemDto> news) {
        news.forEach(newsItemDto ->
                newsDao.saveAll(news));
    }

    private void sendToKafka(List<NewsItemDto> news) {
        news.forEach(newsItem -> {
            if(newsItem.getImage() != null && newsItem.getNewsItemId() != null) {
                ImageDto imageDto = new ImageDto(newsItem.getImage(), newsItem.getNewsItemId());
                kafkaPublisherService.sendImageToProcess(imageDto);
            }
        });
    }

}
