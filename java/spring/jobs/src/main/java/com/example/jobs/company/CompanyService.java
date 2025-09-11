package com.example.jobs.company;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompanies();

    void createCompany(Company company);

    boolean updateCompany(Company updatedCompany, Long id);
}