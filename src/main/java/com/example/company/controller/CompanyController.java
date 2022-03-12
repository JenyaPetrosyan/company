package com.example.company.controller;


import com.example.company.entity.Company;
import com.example.company.repository.CompanyRepository;
import com.example.company.servise.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping("/company")
    public String companyPage(ModelMap map) {
        List<Company> companies = companyService.findAll();
        map.addAttribute("companies", companies);
        return "company";
    }


    @PostMapping("/addCompany")
    public String addCompany(@ModelAttribute Company company){
        companyService.save(company);
        return "redirect:/company";
    }


    @GetMapping("/deleteCompany/{id}")
    public String deleteCompany(@PathVariable("id") int id) {
        companyService.deleteById(id);
        return "redirect:/company";

    }
}
