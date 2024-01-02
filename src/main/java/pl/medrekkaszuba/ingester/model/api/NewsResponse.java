package pl.medrekkaszuba.ingester.model.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.medrekkaszuba.ingester.model.NewsItemDto;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsResponse {
    private String status;
    private List<NewsItemDto> news;
}
