package com.example.company.servise;

import com.example.company.entity.Company;
import com.example.company.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    public void save(Company company) {
        companyRepository.save(company);
    }


    public void deleteById(int id) {
        companyRepository.deleteById(id);
    }


    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    public Company findById(int companyId) {
        return companyRepository.findById(companyId).orElse(null);
    }
}
