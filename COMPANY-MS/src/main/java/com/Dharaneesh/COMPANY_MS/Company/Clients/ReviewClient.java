package com.Dharaneesh.COMPANY_MS.Company.Clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "REVIEW-MS")
public interface ReviewClient {

    @GetMapping("/review/averageRating")
    Double getAverageRating(@RequestParam Long companyId);
}
