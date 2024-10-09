package com.Dharaneesh.JOB_MS.Job.DTO;

import com.Dharaneesh.JOB_MS.Job.External.Company;
import com.Dharaneesh.JOB_MS.Job.External.Review;
import com.Dharaneesh.JOB_MS.Job.Job;

import java.util.List;

public class JobDTO {

    private Job job;
    private Company company;
    private List<Review> reviews;

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
