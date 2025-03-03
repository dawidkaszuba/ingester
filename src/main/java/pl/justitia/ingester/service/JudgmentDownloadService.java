package pl.justitia.ingester.service;


public interface JudgmentDownloadService {

    void getJudgments(int pageSize, int pageNumber);
}
