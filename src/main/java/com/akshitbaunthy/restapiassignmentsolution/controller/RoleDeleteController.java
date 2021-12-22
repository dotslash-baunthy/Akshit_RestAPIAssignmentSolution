package com.akshitbaunthy.restapiassignmentsolution.controller;

import com.akshitbaunthy.restapiassignmentsolution.service.RoleDeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role/delete")
public class RoleDeleteController {

    RoleDeleteService roleDeleteService;

    @Autowired
    RoleDeleteController(RoleDeleteService roleDeleteService) {
        this.roleDeleteService = roleDeleteService;
    }

    @DeleteMapping("/single")
    public void deleteById(@RequestParam Integer id) {
        roleDeleteService.deleteById(id);
    }
}
