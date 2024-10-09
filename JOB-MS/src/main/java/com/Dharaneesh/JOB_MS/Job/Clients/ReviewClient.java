package com.Dharaneesh.JOB_MS.Job.Clients;

import com.Dharaneesh.JOB_MS.Job.External.Review;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "REVIEW-MS")
public interface ReviewClient {

    @GetMapping("/review")
    List<Review> getReview(@RequestParam Long companyId);
}
