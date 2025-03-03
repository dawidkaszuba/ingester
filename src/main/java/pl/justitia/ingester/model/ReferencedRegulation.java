package pl.justitia.ingester.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReferencedRegulation {
    private String journalTitle;
    private Integer journalYear;
    private Integer journalNo;
    private Integer journalEntry;
    private String text;
}
