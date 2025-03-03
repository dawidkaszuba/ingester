package pl.justitia.ingester.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.justitia.ingester.service.JudgmentDownloadService;

@RestController
public class DownloadJudgmentController {

    private final JudgmentDownloadService judgmentDownloadService;

    public DownloadJudgmentController(JudgmentDownloadService judgmentDownloadService) {
        this.judgmentDownloadService = judgmentDownloadService;
    }

    @GetMapping("/get-judgment")
    public void getJudgment(@RequestParam("pageSize") Integer pageSize, @RequestParam("pageNumber") Integer pageNumber) {
        judgmentDownloadService.getJudgments(pageSize, pageNumber);
    }
}
