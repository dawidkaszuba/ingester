package pl.justitia.ingester.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Item {
    private Integer id;
    private String courtType;
    private List<CourtCase> courtCases;
    private String judgmentType;
    private List<Judge> judges;
    private Source source;
    private List<String> courtReporters;
    private String decision;
    private String summary;
    private String textContent;
    private List<String> legalBases;
    private List<ReferencedRegulation> referencedRegulations;
    private List<String> keywords;
    private List<ReferencedCourtCase> referencedCourtCases;
    private Date receiptDate;
    private String meansOfAppeal;
    private String judgmentResult;
    private List<String> lowerCourtJudgments;
    private String personnelType;
    private JudgmentForm judgmentForm;
    private Long divisionId;
    private List<Chamber> chambers;
    private List<DissentingOpinion> dissentingOpinions;
    private Date judgmentDate;

}
