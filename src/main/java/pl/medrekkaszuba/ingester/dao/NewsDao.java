package pl.medrekkaszuba.ingester.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.medrekkaszuba.ingester.model.Image;
import pl.medrekkaszuba.ingester.model.ImageStatus;
import pl.medrekkaszuba.ingester.model.NewsItem;
import pl.medrekkaszuba.ingester.repository.NewsRepository;
import pl.medrekkaszuba.ingester.utils.ImageUtils;
import pl.medrekkaszuba.ingester.model.NewsItemDto;

import java.util.List;

@Slf4j
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
        newsItem.setImage(prepareImage(dto.getImage(), dto.getNewsItemId()));
        return newsItem;
    }

    private Image prepareImage(String imageUrl, String newsItemId) {
        if (imageUrl != null && ImageUtils.isValidURL(imageUrl) && newsItemId != null) {
            Image image = new Image();
            image.setStatus(ImageStatus.TO_PROCESS);
            image.setSourceUrl(imageUrl);
            image.setNewsItemId(newsItemId);
            return image;
        }
        return null;
    }

}
