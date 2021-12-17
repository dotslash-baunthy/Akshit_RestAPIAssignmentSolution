package com.akshitbaunthy.restapiassignmentsolution.service;

import com.akshitbaunthy.restapiassignmentsolution.entity.Employee;
import com.akshitbaunthy.restapiassignmentsolution.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeCreateServiceImpl implements EmployeeCreateService {

    EmployeeRepository createRepository;

    @Autowired
    private void employeeCreateService(EmployeeRepository employeeRepository) {
        this.createRepository = employeeRepository;
    }

    @Override
    public String addEmployees(List<Employee> employees) {
        createRepository.saveAllAndFlush(employees);
        return "Libraries have been added to the directory";
    }

    @Override
    public String addEmployee(Employee employee) {
        createRepository.saveAndFlush(employee);
        return ("Library with ID " + employee.getEmployeeId() + " has been added to the directory");
    }

}
