package com.akshitbaunthy.restapiassignmentsolution.service;

import com.akshitbaunthy.restapiassignmentsolution.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeCreateService {

    Employee addEmployee(Employee employee);
    List<Employee> addEmployees(List<Employee> employees);

}
