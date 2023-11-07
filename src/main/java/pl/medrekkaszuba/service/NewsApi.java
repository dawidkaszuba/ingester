package pl.medrekkaszuba.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import pl.medrekkaszuba.config.FeignConfig;
import pl.medrekkaszuba.model.api.NewsResponse;

import java.util.Map;

@FeignClient(name = "newsApi",url = "${news.api.url}", configuration = FeignConfig.class)
public interface NewsApi {

    @GetMapping("/v1/latest-news")
    NewsResponse getNews(@SpringQueryMap Map<String, String> parameters);

    @GetMapping("/v1/search?{parameters}")
    NewsResponse searchNews(@SpringQueryMap Map<String, String> parameters);
}
