package com.Dharaneesh.JOB_MS.Job;

import com.Dharaneesh.JOB_MS.Job.DTO.JobDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<JobDTO>> getJob()
    {
        return new ResponseEntity<>(jobService.getJob(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job)
    {
        jobService.createJob(job);
        return new ResponseEntity<>("CREATED SUCCESS",HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id)
    {
        Job job=jobService.getJobById(id);

        if(job!=null)
        {
            return new ResponseEntity<>(job,HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateJobById(@PathVariable Long id,@RequestBody Job job)
    {
        boolean res=jobService.updateJobById(id,job);

        if(res)
        {
            return new ResponseEntity<>("UPDATE SUCCESS",HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("NOT_FOUND",HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id)
    {
        boolean res=jobService.deleteJobById(id);

        if(res)
        {
            return new ResponseEntity<>("DELETED SUCCESS",HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("NOT_FOUND",HttpStatus.NOT_FOUND);
        }
    }

}
