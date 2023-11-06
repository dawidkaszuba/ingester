package pl.medrekkaszuba.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@Entity
public class NewsItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String newsItemId;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String description;
    private String url;
    @Column(columnDefinition = "TEXT")
    private String author;
    @OneToOne(cascade = CascadeType.ALL)
    private Image image;
    private String language;
    private String category;
    private String published;
}
