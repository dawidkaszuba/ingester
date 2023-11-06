package pl.medrekkaszuba.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.medrekkaszuba.config.FeignConfig;
import pl.medrekkaszuba.model.api.NewsResponse;

@FeignClient(name = "newsApi",url = "${news.api.url}", configuration = FeignConfig.class)
public interface NewsApi {

    @GetMapping("/v1/latest-news")
    NewsResponse getNews(@RequestParam("language") String language);

    @GetMapping("/v1/search")
    NewsResponse searchNews(@RequestParam("language") String language,
                            @RequestParam("keywords") String keywords,
                            @RequestParam("country") String country,
                            @RequestParam("category") String category,
                            @RequestParam("startDate") String startDate,
                            @RequestParam("endDate") String endDate);
}