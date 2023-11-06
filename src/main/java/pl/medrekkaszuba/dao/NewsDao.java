package pl.medrekkaszuba.dao;

import org.springframework.stereotype.Component;
import pl.medrekkaszuba.model.NewsItem;
import pl.medrekkaszuba.model.NewsItemDto;
import pl.medrekkaszuba.repository.NewsRepository;

import java.util.List;

@Component
public class NewsDao {

    private final NewsRepository newsRepository;

    public NewsDao(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }


    public void saveAll(List<NewsItemDto> news) {
        news.forEach(newsDto -> newsRepository.save(mapNewsDtoToNewsItem(newsDto)));
    }

    private NewsItem mapNewsDtoToNewsItem(NewsItemDto dto) {
        NewsItem newsItem = new NewsItem();
        newsItem.setNewsItemId(dto.getNewsItemId());
        newsItem.setTitle(dto.getTitle());
        newsItem.setDescription(dto.getDescription());
        newsItem.setUrl(dto.getUrl());
        newsItem.setAuthor(dto.getAuthor());
        newsItem.setLanguage(dto.getLanguage());
        newsItem.setCategory(String.join(",", dto.getCategory()));
        newsItem.setPublished(dto.getPublished());
        return newsItem;
    }
}
