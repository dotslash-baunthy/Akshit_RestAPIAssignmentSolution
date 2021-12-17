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
    public String deleteById(Long id) {
        deleteRepository.deleteById(id);
        return "The Employee with ID " + id + " is no longer with the company.";
    }

    @Override
    public String deleteAll() {
        return "The company now has no employees";
    }
}
