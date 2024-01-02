package pl.medrekkaszuba.ingester.model.api;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
public class SearchNewsRequest {
    private String language;
    private String keywords;
    private String country;
    private String category;
    @DateTimeFormat(pattern = "YYYY-MM-DDTHH:MM:SS+00:00")
    private OffsetDateTime startDate;
    @DateTimeFormat(pattern = "YYYY-MM-DDTHH:MM:SS+00:00")
    private OffsetDateTime endDate;
    private Integer limit;
    private Integer pageSize;
    private Integer pageNumber;


}
