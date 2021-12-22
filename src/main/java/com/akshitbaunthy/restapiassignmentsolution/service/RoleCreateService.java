package com.akshitbaunthy.restapiassignmentsolution.service;

import com.akshitbaunthy.restapiassignmentsolution.entity.Role;
import org.springframework.stereotype.Service;

@Service
public interface RoleCreateService {

    public Role addRole(Role role);

}
