package com.akshitbaunthy.restapiassignmentsolution.controller;

import com.akshitbaunthy.restapiassignmentsolution.service.EmployeeDeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delete")
public class EmployeeDeleteController {

    EmployeeDeleteService employeeDeleteService;

    @Autowired
    private EmployeeDeleteController(EmployeeDeleteService employeeDeleteService) {
        this.employeeDeleteService = employeeDeleteService;
    }

    @GetMapping("/single")
    public String deleteById(Long id) {
        return employeeDeleteService.deleteById(id);
    }

}
