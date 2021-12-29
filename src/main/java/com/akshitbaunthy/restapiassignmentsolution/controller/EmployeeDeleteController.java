package com.akshitbaunthy.restapiassignmentsolution.controller;

import com.akshitbaunthy.restapiassignmentsolution.entity.Employee;
import com.akshitbaunthy.restapiassignmentsolution.service.EmployeeDeleteService;
import com.akshitbaunthy.restapiassignmentsolution.service.EmployeeReadService;
import com.akshitbaunthy.restapiassignmentsolution.service.EmployeeUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/employee/delete")
// ServiceImpl does the actual job. The controller only exposes endpoints
public class EmployeeDeleteController {

    EmployeeDeleteService employeeDeleteService;

    //    Constructor injection
    @Autowired
    private EmployeeDeleteController(EmployeeDeleteService employeeDeleteService) {
        this.employeeDeleteService = employeeDeleteService;
    }

    //    Delete a single employee (ID provided as path variable)
    @DeleteMapping("/single/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Integer id) {
        boolean isDeleted = employeeDeleteService.deleteById(id);
        if (isDeleted) {
            return null;
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //    Delete all employees
    @DeleteMapping("/bulk")
    public void deleteAll() {
        employeeDeleteService.deleteAll();
    }
}
