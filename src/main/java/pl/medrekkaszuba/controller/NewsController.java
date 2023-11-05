package pl.medrekkaszuba.controller;

import org.springframework.web.bind.annotation.*;
import pl.medrekkaszuba.model.api.LatestNewsRequest;
import pl.medrekkaszuba.service.NewsService;

@RestController
@RequestMapping("/api")
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }


    @PostMapping("/latest-news")
    public void getNews(@RequestBody LatestNewsRequest request) {
        newsService.processNews(request);
    }
}
