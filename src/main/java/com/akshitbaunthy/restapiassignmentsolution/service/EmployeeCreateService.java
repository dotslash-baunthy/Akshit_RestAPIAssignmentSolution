package com.akshitbaunthy.restapiassignmentsolution.service;

import com.akshitbaunthy.restapiassignmentsolution.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeCreateService {

    String addEmployee(Employee employee);
    String addEmployees(List<Employee> employees);

}
