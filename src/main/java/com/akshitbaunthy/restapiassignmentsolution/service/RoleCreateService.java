package com.akshitbaunthy.restapiassignmentsolution.service;

import com.akshitbaunthy.restapiassignmentsolution.entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleCreateService {

    Role addRole(Role role);
    List<Role> addRoles(List<Role> roles);

}
