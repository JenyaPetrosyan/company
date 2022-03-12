package com.example.company.controller;


import com.example.company.dto.CreateEmployeeRequest;
import com.example.company.servise.CompanyService;
import com.example.company.servise.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    private final CompanyService companyService;

    @GetMapping("/employee")
    public String employeePage(ModelMap map) {
        map.addAttribute("companies", companyService.findAll());
        map.addAttribute("employees", employeeService.findAll());
        return "employee";
    }


    @PostMapping("/addEmployee")
    public String addEmployee(@ModelAttribute CreateEmployeeRequest createEmployeeRequest) {
        employeeService.saveEmployeeFromRequest(createEmployeeRequest);
        return "redirect:/employee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        employeeService.deleteById(id);
        return "redirect:/employee";
    }


}
