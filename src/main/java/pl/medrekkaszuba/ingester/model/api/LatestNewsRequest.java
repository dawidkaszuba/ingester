package pl.medrekkaszuba.ingester.model.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LatestNewsRequest {
    private String language;
}
