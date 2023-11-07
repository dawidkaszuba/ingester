package pl.medrekkaszuba.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TEXT")
    private String sourceUrl;
    private String url;
    private String newsItemId;
    @Enumerated(EnumType.STRING)
    private ImageStatus status;

}
