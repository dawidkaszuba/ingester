package pl.medrekkaszuba.service;

import org.springframework.stereotype.Service;
import pl.medrekkaszuba.model.api.LatestNewsRequest;

@Service
public interface NewsService {
    void processNews(LatestNewsRequest request);

}
