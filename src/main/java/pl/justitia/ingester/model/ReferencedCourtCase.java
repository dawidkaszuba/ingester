package pl.justitia.ingester.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ReferencedCourtCase {
    private String caseNumber;
    private List<String> judgmentIds;
    private Boolean generated;
}
