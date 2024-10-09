package com.Dharaneesh.JOB_MS.Job;

import com.Dharaneesh.JOB_MS.Job.DTO.JobDTO;

import java.util.List;

public interface JobService {
    List<JobDTO> getJob();

    void createJob(Job job);

    JobDTO getJobById(Long id);

    boolean updateJobById(Long id, Job job);

    boolean deleteJobById(Long id);
}
