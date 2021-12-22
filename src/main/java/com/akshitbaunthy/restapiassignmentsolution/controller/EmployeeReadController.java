package com.akshitbaunthy.restapiassignmentsolution.controller;

import com.akshitbaunthy.restapiassignmentsolution.entity.Employee;
import com.akshitbaunthy.restapiassignmentsolution.service.EmployeeReadService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Optional<Employee> getById(@RequestParam Integer id) {
        return employeeReadService.getById(id);
    }

    @GetMapping("/bulk")
    public List<Employee> getAll() {
        return employeeReadService.getAll();
    }
}
