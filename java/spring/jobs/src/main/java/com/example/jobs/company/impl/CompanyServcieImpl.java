package com.example.jobs.company.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.jobs.company.Company;
import com.example.jobs.company.CompanyRepository;
import com.example.jobs.company.CompanyService;

@Service
public class CompanyServcieImpl implements CompanyService {

    private CompanyRepository companyRepository;

    public CompanyServcieImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public boolean updateCompany(Company updatedCompany, Long id) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if (companyOptional.isPresent()) {
            Company company = companyOptional.get();

            company.setName(updatedCompany.getName());
            company.setDescription(updatedCompany.getDescription());
            company.setJobs(updatedCompany.getJobs());

            companyRepository.save(company);
            return true;
        }
        return false;
    }
}