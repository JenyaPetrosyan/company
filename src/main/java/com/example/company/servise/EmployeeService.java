package com.example.company.servise;

import com.example.company.dto.CreateEmployeeRequest;
import com.example.company.entity.Company;
import com.example.company.entity.Employee;
import com.example.company.entity.EmployeeImage;
import com.example.company.repository.CompanyRepository;
import com.example.company.repository.EmployeeImageRepository;
import com.example.company.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final CompanyRepository companyRepository;
   // private final EmployeeImageRepository employeeImageRepository;
  //  @Value("${company.upload.path}")
    //private String imagePath;


    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }


    public void deleteById(int id) {
        employeeRepository.deleteById(id);

    }

    public void saveEmployeeFromRequest(CreateEmployeeRequest createEmployeeRequest) {
        Employee employee = Employee.builder()
                .id(createEmployeeRequest.getId())
                .name(createEmployeeRequest.getName())
                .surname(createEmployeeRequest.getSurname())
                .email(createEmployeeRequest.getEmail())
                .company(companyRepository.findById(createEmployeeRequest.getCompanyId()).orElse(null))
                .phoneNumber(createEmployeeRequest.getPhoneNumber())
                .salary(createEmployeeRequest.getSalary())
                .position(createEmployeeRequest.getPosition())
                .build();
        employeeRepository.save(employee);
    }

    /*private void saveEmployeeImage(MultipartFile[] uploadedFiles, Employee employee) throws IOException {
        if (uploadedFiles.length != 0) {
            for (MultipartFile uploadedFile : uploadedFiles) {
                String fileName = System.currentTimeMillis() + "_" + uploadedFile.getOriginalFilename();
                File newFile = new File(imagePath + fileName);
                uploadedFile.transferTo(newFile);
                EmployeeImage employeeImage = EmployeeImage.builder()
                        .name(fileName)
                        .employee(employee)
                        .build();

                employeeImageRepository.save(employeeImage);
            }

        }*/
    }



