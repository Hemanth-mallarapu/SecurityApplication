package com.example.SecurityApp.controller;

import com.example.SecurityApp.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "/securityApp/api/v1/employees")
public class EmployeeController {

    private static final List<Employee> employees = Arrays.asList(
            new Employee(1, "Hemanth", 25000),
            new Employee(2, "Kumar", 75000),
            new Employee(3, "Mallarapu", 34000));
    @GetMapping(path = "{empId}")
    public Employee getEmpById(@PathVariable("empId") Integer empId){
        return  employees.stream()
                .filter(employee ->
                        empId.equals(employee.getEmpId()))
                .findFirst()
                .orElseThrow(()->
                        new IllegalStateException("Employee "+empId+ " does not exist.!!!"));

    }


}
