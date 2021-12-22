package com.akshitbaunthy.restapiassignmentsolution.controller;

import com.akshitbaunthy.restapiassignmentsolution.entity.Employee;
import com.akshitbaunthy.restapiassignmentsolution.service.EmployeeCreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/create")
public class EmployeeCreateController {

    EmployeeCreateService employeeCreateService;

    @Autowired
    private EmployeeCreateController(EmployeeCreateService employeeCreateService) {
        this.employeeCreateService = employeeCreateService;
    }

    @PostMapping("/single")
    public String addEmployee(@RequestBody Employee employee) {
        return employeeCreateService.addEmployee(employee);
    }

    @PostMapping("/bulk")
    public String addEmployees(@RequestBody List<Employee> employees) {
        return employeeCreateService.addEmployees(employees);
    }
}
