package com.akshitbaunthy.restapiassignmentsolution.service;

import com.akshitbaunthy.restapiassignmentsolution.entity.Employee;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeUpdateService {

    String updateById(Long id, Employee employee);

}
