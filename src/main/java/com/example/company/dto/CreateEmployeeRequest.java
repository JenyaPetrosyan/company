package com.example.company.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateEmployeeRequest {
    private int id;
    private String name;
    private String surname;
    private String email;
    private int companyId;
    private String phoneNumber;
    private int salary;
    private String position;
}
