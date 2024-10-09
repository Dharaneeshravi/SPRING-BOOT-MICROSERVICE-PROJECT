package com.Dharaneesh.COMPANY_MS.Company;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<Company>> getCompany()
    {
        return new ResponseEntity<>(companyService. getCompany(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createCompany(@RequestBody Company company)
    {
        companyService.createCompany(company);
        return new ResponseEntity<>("CREATED SUCCESS",HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id)
    {
        Company company=companyService.getCompanyById(id);

        if(company!=null)
        {
            return new ResponseEntity<>(company,HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompanyById(@PathVariable Long id,@RequestBody Company company)
    {
        boolean res=companyService. updateCompanyById(id,company);

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
    public ResponseEntity<String> deleteCompanyById(@PathVariable long id)
    {
        boolean res=companyService.deleteCompanyById(id);

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
