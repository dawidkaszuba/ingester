package pl.justitia.ingester.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DissentingOpinion {
    private String textContent;
    private List<String> authors;
}
