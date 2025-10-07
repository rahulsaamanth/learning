package com.example.company_ms.company.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.company_ms.company.Company;
import com.example.company_ms.company.CompanyRepository;
import com.example.company_ms.company.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
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

            companyRepository.save(company);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCompany(Long id) {
        try {
            companyRepository.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}