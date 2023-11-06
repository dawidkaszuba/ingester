package pl.medrekkaszuba.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ImageDto {
    private String url;
    private String newsItemId;
}
