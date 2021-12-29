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
public class EmployeeDeleteController {

    EmployeeDeleteService employeeDeleteService;
    EmployeeReadService employeeReadService;

    @Autowired
    private EmployeeDeleteController(EmployeeDeleteService employeeDeleteService, EmployeeReadService employeeReadService) {
        this.employeeDeleteService = employeeDeleteService;
        this.employeeReadService = employeeReadService;
    }

    @DeleteMapping("/single")
    public ResponseEntity<HttpStatus> deleteById(@RequestParam Integer id) {
        if (id != 0) {
            boolean isDeleted = employeeDeleteService.deleteById(id);
            if (isDeleted) {
                return null;
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
