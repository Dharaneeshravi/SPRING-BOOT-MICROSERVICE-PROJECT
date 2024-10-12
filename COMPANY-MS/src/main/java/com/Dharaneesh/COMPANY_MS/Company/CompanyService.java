package com.Dharaneesh.COMPANY_MS.Company;

import com.Dharaneesh.COMPANY_MS.Company.DTO.ReviewMessage;

import java.util.List;

public interface CompanyService {
    List<Company> getCompany();

    void createCompany(Company company);

    Company getCompanyById(Long id);

    boolean updateCompanyById(Long id, Company company);

    boolean deleteCompanyById(long id);

   public void updateCompanyRating(ReviewMessage reviewMessage);
}
