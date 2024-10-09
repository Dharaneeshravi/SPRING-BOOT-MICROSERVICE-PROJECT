package com.Dharaneesh.JOB_MS.Job.DTO;


import com.Dharaneesh.JOB_MS.Job.External.Company;
import com.Dharaneesh.JOB_MS.Job.External.Review;
import com.Dharaneesh.JOB_MS.Job.Job;

import java.util.List;

public class JobDTO {

    private Long id;
    private String title;
    private String description;
    private Long minsalary;
    private Long maxsalary;
    private String location;
    private Company company;
    private List<Review> reviews;



    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getMinsalary() {
        return minsalary;
    }

    public void setMinsalary(Long minsalary) {
        this.minsalary = minsalary;
    }

    public Long getMaxsalary() {
        return maxsalary;
    }

    public void setMaxsalary(Long maxsalary) {
        this.maxsalary = maxsalary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
