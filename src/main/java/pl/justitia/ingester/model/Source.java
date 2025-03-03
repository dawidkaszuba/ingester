package pl.justitia.ingester.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Source {
    private String code;
    private String judgmentUrl;
    private String judgmentId;
    private String publisher;
    private String reviser;
    private Date publicationDate;
}
