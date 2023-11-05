package pl.medrekkaszuba.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class NewsItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dbId;
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
