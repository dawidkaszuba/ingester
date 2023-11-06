package pl.medrekkaszuba.model.api;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SearchNewsRequest {
    private String language;
    private String keywords;
    private String country;
    private String category;
    private String startDate;
    private String endDate;
}
