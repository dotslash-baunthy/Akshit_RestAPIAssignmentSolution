package com.akshitbaunthy.restapiassignmentsolution.service;

import com.akshitbaunthy.restapiassignmentsolution.entity.Employee;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeUpdateService {

    Employee updateById(Integer id, Employee employee);

}
