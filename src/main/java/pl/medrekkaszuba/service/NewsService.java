package pl.medrekkaszuba.service;

import org.springframework.stereotype.Service;
import pl.medrekkaszuba.model.api.LatestNewsRequest;
import pl.medrekkaszuba.model.api.SearchNewsRequest;

@Service
public interface NewsService {

    void getLatestNews(LatestNewsRequest request);

    void searchNews(SearchNewsRequest request);
}
