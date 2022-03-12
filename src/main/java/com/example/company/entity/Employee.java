package com.example.company.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private String email;
    @ManyToOne
    private Company company;
    private String phoneNumber;
    private int salary;
    private String position;

    @OneToMany(mappedBy = "employee")
    private List<EmployeeImage> employeeImageList;
}
