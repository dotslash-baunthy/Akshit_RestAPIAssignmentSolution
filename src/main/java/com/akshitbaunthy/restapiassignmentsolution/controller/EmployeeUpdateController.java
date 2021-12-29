package com.akshitbaunthy.restapiassignmentsolution.controller;

import com.akshitbaunthy.restapiassignmentsolution.entity.Employee;
import com.akshitbaunthy.restapiassignmentsolution.service.EmployeeReadService;
import com.akshitbaunthy.restapiassignmentsolution.service.EmployeeUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/employee/update")
public class EmployeeUpdateController {

    EmployeeUpdateService employeeUpdateService;

    @Autowired
    private EmployeeUpdateController(EmployeeUpdateService employeeUpdateService) {
        this.employeeUpdateService = employeeUpdateService;
    }

    @PostMapping("/single")
    public ResponseEntity<Employee> updateById(@RequestParam Integer id, @RequestBody Employee fetchedEmployee) {
        Employee updatedEmployee = employeeUpdateService.updateById(id, fetchedEmployee);
        if (updatedEmployee != null) {
            return new ResponseEntity<Employee>(updatedEmployee, HttpStatus.OK);
        } else {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
    }

}
