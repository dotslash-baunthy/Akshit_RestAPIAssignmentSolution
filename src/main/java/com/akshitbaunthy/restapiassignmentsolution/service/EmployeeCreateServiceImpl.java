package com.akshitbaunthy.restapiassignmentsolution.service;

import com.akshitbaunthy.restapiassignmentsolution.entity.Employee;
import com.akshitbaunthy.restapiassignmentsolution.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeCreateServiceImpl implements EmployeeCreateService {

    EmployeeRepository createRepository;

    @Autowired
    private void employeeCreateService(EmployeeRepository employeeRepository) {
        this.createRepository = employeeRepository;
    }

    @Override
    public List<Employee> addEmployees(List<Employee> employees) {
        List<Employee> createdEmployees = createRepository.saveAllAndFlush(employees);
        return createdEmployees;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        Employee createdEmployee = createRepository.saveAndFlush(employee);
        return createdEmployee;
    }

}
