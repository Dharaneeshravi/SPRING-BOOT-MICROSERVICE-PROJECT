package com.Dharaneesh.JOB_MS.Job.Mapper;

import com.Dharaneesh.JOB_MS.Job.DTO.JobDTO;
import com.Dharaneesh.JOB_MS.Job.External.Company;
import com.Dharaneesh.JOB_MS.Job.External.Review;
import com.Dharaneesh.JOB_MS.Job.Job;

import java.util.List;

public class JobMapper {

    public static JobDTO MapToJobDto(Job job, Company company, List<Review> reviews)
    {
        JobDTO jobDTO=new JobDTO();
        jobDTO.setTitle(job.getTitle());
        jobDTO.setDescription(job.getDescription());
        jobDTO.setMinsalary(job.getMinsalary());
        jobDTO.setMaxsalary(job.getMaxsalary());
        jobDTO.setId(job.getId());
        jobDTO.setCompany(company);
        jobDTO.setReviews(reviews);
        return jobDTO;
    }
}
