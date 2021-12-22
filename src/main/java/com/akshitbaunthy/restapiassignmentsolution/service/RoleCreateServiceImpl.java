package com.akshitbaunthy.restapiassignmentsolution.service;

import com.akshitbaunthy.restapiassignmentsolution.entity.Role;
import com.akshitbaunthy.restapiassignmentsolution.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleCreateServiceImpl implements RoleCreateService{

    RoleRepository createRepository;

    @Autowired
    RoleCreateServiceImpl (RoleRepository roleRepository) {
        this.createRepository = roleRepository;
    }

    @Override
    public Role addRole(Role role) {
        Role createdRole = createRepository.save(role);
        return createdRole;
    }
}
