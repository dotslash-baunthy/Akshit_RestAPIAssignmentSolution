package com.akshitbaunthy.restapiassignmentsolution.controller;

import com.akshitbaunthy.restapiassignmentsolution.entity.Employee;
import com.akshitbaunthy.restapiassignmentsolution.service.EmployeeUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/update")
public class EmployeeUpdateController {

    EmployeeUpdateService employeeUpdateService;

    @Autowired
    private EmployeeUpdateController (EmployeeUpdateService employeeUpdateService) {
        this.employeeUpdateService = employeeUpdateService;
    }

    @PostMapping("/single")
    public String updateById(Long id, @RequestBody Employee fetchedEmployee) {
        return employeeUpdateService.updateById(id, fetchedEmployee);
    }

}
