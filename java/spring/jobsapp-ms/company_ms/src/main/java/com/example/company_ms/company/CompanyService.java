package com.example.company_ms.company;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompanies();

    void createCompany(Company company);

    Company getCompanyById(Long id);

    boolean updateCompany(Company updatedCompany, Long id);

    boolean deleteCompany(Long id);
}