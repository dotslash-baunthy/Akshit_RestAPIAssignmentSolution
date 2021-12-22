package com.akshitbaunthy.restapiassignmentsolution.service;

import com.akshitbaunthy.restapiassignmentsolution.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleDeleteServiceImpl implements RoleDeleteService{

    RoleRepository deleteRepository;

    @Autowired
    RoleDeleteServiceImpl (RoleRepository roleRepository) {
        this.deleteRepository = roleRepository;
    }

    @Override
    public void deleteById(Integer id) {

        deleteRepository.deleteById(id);

    }
}
