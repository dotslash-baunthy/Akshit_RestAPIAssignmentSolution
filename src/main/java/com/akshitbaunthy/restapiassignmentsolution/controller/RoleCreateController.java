package com.akshitbaunthy.restapiassignmentsolution.controller;

import com.akshitbaunthy.restapiassignmentsolution.entity.Role;
import com.akshitbaunthy.restapiassignmentsolution.service.RoleCreateService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Role addRole(@RequestBody Role role) {
        return roleCreateService.addRole(role);
    }

}
