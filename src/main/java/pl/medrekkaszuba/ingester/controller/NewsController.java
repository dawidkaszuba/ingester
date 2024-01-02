package pl.medrekkaszuba.ingester.controller;

import org.springframework.web.bind.annotation.*;
import pl.medrekkaszuba.ingester.model.api.LatestNewsRequest;
import pl.medrekkaszuba.ingester.service.NewsService;
import pl.medrekkaszuba.ingester.model.api.SearchNewsRequest;

@RestController
@RequestMapping("/api")
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }


    @PostMapping("/latest-news")
    public void getNews(@RequestBody LatestNewsRequest request) {
        newsService.getLatestNews(request);
    }

    @PostMapping("/search-news")
    public void searchNews(@RequestBody SearchNewsRequest request) {
        newsService.searchNews(request);
    }
}
