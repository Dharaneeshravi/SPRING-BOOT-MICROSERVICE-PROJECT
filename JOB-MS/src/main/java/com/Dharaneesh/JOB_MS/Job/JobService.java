package com.Dharaneesh.JOB_MS.Job;

import java.util.List;

public interface JobService {
    List<Job> getJob();

    void createJob(Job job);

    Job getJobById(Long id);

    boolean updateJobById(Long id, Job job);

    boolean deleteJobById(Long id);
}
