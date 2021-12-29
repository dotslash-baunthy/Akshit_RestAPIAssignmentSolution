package com.akshitbaunthy.restapiassignmentsolution.service;

import com.akshitbaunthy.restapiassignmentsolution.entity.Employee;
import com.akshitbaunthy.restapiassignmentsolution.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// This service class does the actual employee creation
@Service
public class EmployeeCreateServiceImpl implements EmployeeCreateService {

    EmployeeRepository createRepository;

    //    Constructor injection
    @Autowired
    private EmployeeCreateServiceImpl(EmployeeRepository employeeRepository) {
        this.createRepository = employeeRepository;
    }

    //    Add employees in bulk
    @Override
    public List<Employee> addEmployees(List<Employee> employees) {
        return createRepository.saveAllAndFlush(employees);
    }

    //    Add a single employee
    @Override
    public Employee addEmployee(Employee employee) {
        return createRepository.saveAndFlush(employee);
    }

}
