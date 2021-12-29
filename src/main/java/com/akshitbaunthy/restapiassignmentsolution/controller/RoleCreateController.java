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

import java.util.List;

@RestController
@RequestMapping("/role/create")
// ServiceImpl does the actual job. The controller only exposes endpoints
public class RoleCreateController {

    RoleCreateService roleCreateService;

    //    Constructor injection
    @Autowired
    RoleCreateController(RoleCreateService roleCreateService) {
        this.roleCreateService = roleCreateService;
    }

    //    Create a single role (body provided in REST API client)
    @PostMapping("/single")
    public ResponseEntity<Role> addRole(@RequestBody Role role) {
        Role createdRole = roleCreateService.addRole(role);
        return new ResponseEntity<Role>(createdRole, HttpStatus.OK);
    }

    //    Create multiple employees (body is an array of Employee objects, provided in REST API client)
    @PostMapping("/bulk")
    public ResponseEntity<List<Role>> addRoles(@RequestBody List<Role> roles) {
        List<Role> createdRoles = roleCreateService.addRoles(roles);
        return new ResponseEntity<List<Role>>(createdRoles, HttpStatus.OK);
    }

}
