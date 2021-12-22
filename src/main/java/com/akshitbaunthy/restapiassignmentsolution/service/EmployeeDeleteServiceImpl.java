package com.akshitbaunthy.restapiassignmentsolution.service;

import com.akshitbaunthy.restapiassignmentsolution.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDeleteServiceImpl implements EmployeeDeleteService {

    EmployeeRepository deleteRepository;

    @Autowired
    private void EmployeeDeleteServiceImpl(EmployeeRepository employeeRepository) {
        this.deleteRepository = employeeRepository;
    }

    @Override
    public void deleteById(Integer id) {
        deleteRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        deleteRepository.deleteAll();
    }
}
