package com.Dharaneesh.JOB_MS.Job.Clients;

import com.Dharaneesh.JOB_MS.Job.External.Company;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "COMPANY-MS")
public interface CompanyClient {

    @GetMapping("/company/{id}")
    Company getcompany(@PathVariable Long id);
}
