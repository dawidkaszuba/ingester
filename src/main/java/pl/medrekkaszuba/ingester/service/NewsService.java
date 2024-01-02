package pl.medrekkaszuba.ingester.service;

import org.springframework.stereotype.Service;
import pl.medrekkaszuba.ingester.model.api.LatestNewsRequest;
import pl.medrekkaszuba.ingester.model.api.SearchNewsRequest;

@Service
public interface NewsService {

    void getLatestNews(LatestNewsRequest request);

    void searchNews(SearchNewsRequest request);
}
