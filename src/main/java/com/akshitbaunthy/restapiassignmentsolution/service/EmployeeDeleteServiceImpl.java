package com.akshitbaunthy.restapiassignmentsolution.service;

import com.akshitbaunthy.restapiassignmentsolution.entity.Employee;
import com.akshitbaunthy.restapiassignmentsolution.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

// This service class does the actual employee deletion
@Service
public class EmployeeDeleteServiceImpl implements EmployeeDeleteService {

    EmployeeRepository deleteRepository;
    EmployeeRepository readRepository;

    //    Constructor injection
    @Autowired
    private EmployeeDeleteServiceImpl(EmployeeRepository employeeRepository) {
        this.deleteRepository = employeeRepository;
        this.readRepository = employeeRepository;
    }

    //    Delete a single employee. This does the actual deletion.
    @Override
    public boolean deleteById(Integer id) {
        Optional<Employee> fetchedEmployee = readRepository.findById(id);
        if (fetchedEmployee.isPresent()) {
            deleteRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    //    Delete all employees
    @Override
    public void deleteAll() {
        deleteRepository.deleteAll();
    }
}
