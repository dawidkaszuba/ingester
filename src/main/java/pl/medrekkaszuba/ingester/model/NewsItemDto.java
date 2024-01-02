package pl.medrekkaszuba.ingester.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class NewsItemDto {

    @JsonProperty("id")
    private String newsItemId;
    private String title;
    private String description;
    private String url;
    private String author;
    private String image;
    private String language;
    private List<String> category;
    private String published;

}
