package com.akshitbaunthy.restapiassignmentsolution.service;

import com.akshitbaunthy.restapiassignmentsolution.entity.Role;
import com.akshitbaunthy.restapiassignmentsolution.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// This service class does the actual role creation
@Service
public class RoleCreateServiceImpl implements RoleCreateService {

    RoleRepository createRepository;

    //    Constructor injection
    @Autowired
    RoleCreateServiceImpl(RoleRepository roleRepository) {
        this.createRepository = roleRepository;
    }

    //    Add a single role
    @Override
    public Role addRole(Role role) {
        return createRepository.save(role);
    }

    //    Add roles in bulk
    @Override
    public List<Role> addRoles(List<Role> roles) {
        return createRepository.saveAll(roles);
    }
}
