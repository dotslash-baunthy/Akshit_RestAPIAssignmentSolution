package com.akshitbaunthy.restapiassignmentsolution.service;

import com.akshitbaunthy.restapiassignmentsolution.entity.Role;
import com.akshitbaunthy.restapiassignmentsolution.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleCreateServiceImpl implements RoleCreateService {

    RoleRepository createRepository;

    @Autowired
    RoleCreateServiceImpl(RoleRepository roleRepository) {
        this.createRepository = roleRepository;
    }

    @Override
    public Role addRole(Role role) {
        return createRepository.save(role);
    }

    @Override
    public List<Role> addRoles(List<Role> roles) {
        return createRepository.saveAll(roles);
    }
}
