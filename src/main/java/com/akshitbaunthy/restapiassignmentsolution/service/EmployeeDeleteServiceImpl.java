package com.akshitbaunthy.restapiassignmentsolution.service;

import com.akshitbaunthy.restapiassignmentsolution.repository.EmployeeRepository;

public class EmployeeDeleteServiceImpl implements EmployeeDeleteService{

    EmployeeRepository deleteRepository;

    private void EmployeeDeleteServiceImpl(EmployeeRepository employeeRepository) {
        this.deleteRepository = employeeRepository;
    }

    @Override
    public String deleteById(Long id) {
        return null;
    }

    @Override
    public String deleteAll() {
        return null;
    }
}
