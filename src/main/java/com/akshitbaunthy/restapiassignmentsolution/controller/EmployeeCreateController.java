package com.akshitbaunthy.restapiassignmentsolution.controller;

import com.akshitbaunthy.restapiassignmentsolution.entity.Employee;
import com.akshitbaunthy.restapiassignmentsolution.service.EmployeeCreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee/create")
public class EmployeeCreateController {

    EmployeeCreateService employeeCreateService;

    @Autowired
    private EmployeeCreateController(EmployeeCreateService employeeCreateService) {
        this.employeeCreateService = employeeCreateService;
    }

    @PostMapping("/single")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee createdEmployee = employeeCreateService.addEmployee(employee);
        return new ResponseEntity<Employee>(createdEmployee, HttpStatus.OK);
    }

    @PostMapping("/bulk")
    public ResponseEntity<List<Employee>> addEmployees(@RequestBody List<Employee> employees) {
        List<Employee> createdEmployees = employeeCreateService.addEmployees(employees);
        return new ResponseEntity<List<Employee>>(createdEmployees, HttpStatus.OK);
    }
}
