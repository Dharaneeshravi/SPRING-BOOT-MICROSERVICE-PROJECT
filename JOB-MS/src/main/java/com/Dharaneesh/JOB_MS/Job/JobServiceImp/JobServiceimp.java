package com.Dharaneesh.JOB_MS.Job.JobServiceImp;

import com.Dharaneesh.JOB_MS.Job.DTO.JobDTO;
import com.Dharaneesh.JOB_MS.Job.External.Company;
import com.Dharaneesh.JOB_MS.Job.External.Review;
import com.Dharaneesh.JOB_MS.Job.Job;
import com.Dharaneesh.JOB_MS.Job.JobRepository;
import com.Dharaneesh.JOB_MS.Job.JobService;
import com.Dharaneesh.JOB_MS.Job.Mapper.JobMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobServiceimp implements JobService {

    private final JobRepository jobRepository;


    public JobServiceimp(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<JobDTO> getJob() {

        List<Job> jobs= jobRepository.findAll();

        return  jobs.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private JobDTO convertToDto(Job job)
    {
        Company company=restTemplate.getForObject("http://COMPANY-MS:8082/company/"+job.getCompanyId(), Company.class);
        ResponseEntity<List<Review>> responseEntity=restTemplate.exchange("http://REVIEW-MS:8083/review?companyId="+job.getCompanyId(), HttpMethod.GET, null, new ParameterizedTypeReference<List<Review>>() {
                        });
        List<Review> reviews=responseEntity.getBody();
        JobDTO jobDTO= JobMapper.MapToJobDto(job,company,reviews);
        return jobDTO;


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
