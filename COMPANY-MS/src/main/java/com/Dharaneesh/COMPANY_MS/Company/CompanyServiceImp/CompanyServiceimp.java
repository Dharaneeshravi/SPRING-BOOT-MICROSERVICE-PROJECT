package com.Dharaneesh.COMPANY_MS.Company.CompanyServiceImp;

import com.Dharaneesh.COMPANY_MS.Company.Clients.ReviewClient;
import com.Dharaneesh.COMPANY_MS.Company.Company;
import com.Dharaneesh.COMPANY_MS.Company.CompanyRepository;
import com.Dharaneesh.COMPANY_MS.Company.CompanyService;
import com.Dharaneesh.COMPANY_MS.Company.DTO.ReviewMessage;
import jakarta.ws.rs.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceimp implements CompanyService {

    private final CompanyRepository companyRepository;
    private final ReviewClient reviewClient;

    public CompanyServiceimp(CompanyRepository companyRepository,ReviewClient reviewClient) {
        this.companyRepository = companyRepository;
        this.reviewClient=reviewClient;
    }

    @Override
    public List<Company> getCompany() {

        return companyRepository.findAll();
    }

    @Override
    public void createCompany(Company company) {

        companyRepository.save(company);
    }

    @Override
    public Company getCompanyById(Long id) {

        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public boolean updateCompanyById(Long id, Company company) {

        Optional<Company> company1=companyRepository.findById(id);

        if(company1.isPresent())
        {
            Company company2=company1.get();
            company2.setName(company.getName());
            company2.setDescription(company.getDescription());
            companyRepository.save(company2);
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public boolean deleteCompanyById(long id) {

        if(companyRepository.existsById(id))
        {
            companyRepository.deleteById(id);
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public void updateCompanyRating(ReviewMessage reviewMessage) {

      Company company=companyRepository.findById(reviewMessage.getCompanyId()).
              orElseThrow(() ->new NotFoundException("company not found"+reviewMessage.getCompanyId()));

      Double rating=reviewClient.getAverageRating(reviewMessage.getCompanyId());

      company.setRating(rating);
      companyRepository.save(company);
       
    }
}
