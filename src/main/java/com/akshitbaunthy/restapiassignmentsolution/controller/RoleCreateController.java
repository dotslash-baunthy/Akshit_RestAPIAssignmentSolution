package com.akshitbaunthy.restapiassignmentsolution.controller;

import com.akshitbaunthy.restapiassignmentsolution.entity.Role;
import com.akshitbaunthy.restapiassignmentsolution.service.RoleCreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role/create")
public class RoleCreateController {

    RoleCreateService roleCreateService;

    @Autowired
    RoleCreateController(RoleCreateService roleCreateService) {
        this.roleCreateService = roleCreateService;
    }

    @PostMapping("/single")
    public ResponseEntity<Role> addRole(@RequestBody Role role) {
        Role createdRole = roleCreateService.addRole(role);
        return new ResponseEntity<Role>(createdRole, HttpStatus.OK);
    }

}
