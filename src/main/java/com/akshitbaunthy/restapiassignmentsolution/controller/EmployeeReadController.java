package com.akshitbaunthy.restapiassignmentsolution.controller;

import com.akshitbaunthy.restapiassignmentsolution.entity.Employee;
import com.akshitbaunthy.restapiassignmentsolution.service.EmployeeReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee/read")
public class EmployeeReadController {

    EmployeeReadService employeeReadService;

    @Autowired
    private EmployeeReadController(EmployeeReadService employeeReadService) {
        this.employeeReadService = employeeReadService;
    }

    @GetMapping("/single")
    public ResponseEntity<Optional<Employee>> getById(@RequestParam Integer id) {
        Optional<Employee> fetchedEmployee = employeeReadService.getById(id);
        if (fetchedEmployee.isPresent()) {
            return new ResponseEntity<Optional<Employee>>(fetchedEmployee, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/bulk")
    public ResponseEntity<List<Employee>> getAll() {
        List<Employee> fetchedEmployees = employeeReadService.getAll();
        return new ResponseEntity<List<Employee>>(fetchedEmployees, HttpStatus.OK);
    }
}
