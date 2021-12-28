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
    EmployeeReadService employeeReadService;

    @Autowired
    private EmployeeUpdateController(EmployeeUpdateService employeeUpdateService, EmployeeReadService employeeReadService) {
        this.employeeReadService = employeeReadService;
        this.employeeUpdateService = employeeUpdateService;
    }

    @PostMapping("/single")
    public ResponseEntity<Employee> updateById(@RequestParam Integer id, @RequestBody Employee fetchedEmployee) {
        Optional<Employee> employeeInDatabase = employeeReadService.getById(id);
        if(employeeInDatabase.isPresent()) {
            Employee updatedEmployee = employeeUpdateService.updateById(id, fetchedEmployee);
            return new ResponseEntity<Employee>(updatedEmployee, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
    }

}
