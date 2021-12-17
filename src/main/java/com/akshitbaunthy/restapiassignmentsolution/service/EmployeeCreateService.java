package com.akshitbaunthy.restapiassignmentsolution.service;

import com.akshitbaunthy.restapiassignmentsolution.entity.Employee;

import java.util.List;

public interface EmployeeCreateService {

    String addEmployee(Employee employee);
    String addEmployees(List<Employee> employees);

}
