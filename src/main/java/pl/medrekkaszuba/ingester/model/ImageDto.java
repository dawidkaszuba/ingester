package pl.medrekkaszuba.ingester.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ImageDto {
    private String url;
    private String newsItemId;
}
