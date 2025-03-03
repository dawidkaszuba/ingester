package pl.justitia.ingester.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Link {
    private String rel;
    private String href;
}
