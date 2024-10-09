package com.Dharaneesh.JOB_MS.Job.JobServiceImp;

import com.Dharaneesh.JOB_MS.Job.Job;
import com.Dharaneesh.JOB_MS.Job.JobRepository;
import com.Dharaneesh.JOB_MS.Job.JobService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceimp implements JobService {

    private final JobRepository jobRepository;

    public JobServiceimp(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> getJob() {

        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {

        jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long id) {

        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean updateJobById(Long id, Job job) {

        Optional<Job> job1=jobRepository.findById(id);

        if(job1.isPresent())
        {
            Job job2=job1.get();
            job2.setTitle(job.getTitle());
            job2.setDescription(job.getDescription());
            job2.setMinsalary(job.getMinsalary());
            job2.setMaxsalary(job.getMaxsalary());
            job2.setLocation(job.getLocation());
            jobRepository.save(job2);
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public boolean deleteJobById(Long id) {

        if(jobRepository.existsById(id))
        {
            jobRepository.deleteById(id);
            return true;
        }
        else
        {
            return false;
        }
    }
}
