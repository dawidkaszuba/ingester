package pl.justitia.ingester.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.justitia.ingester.model.ApiResponse;

@FeignClient(name = "saosClient", url = "https://www.saos.org.pl/api/dump")
public interface SaosClient {

    @GetMapping("/judgments")
    ResponseEntity<ApiResponse> getJudgments(@RequestParam("pageSize") int pageSize, @RequestParam("pageNumber") int pageNumber);
}
