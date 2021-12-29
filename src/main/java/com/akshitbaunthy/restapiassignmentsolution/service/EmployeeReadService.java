package com.akshitbaunthy.restapiassignmentsolution.service;

import com.akshitbaunthy.restapiassignmentsolution.entity.Employee;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public interface EmployeeReadService {

    Optional<Employee> getById(Integer id);
    List<Employee> getAll();
    List<Employee> searchByFirstName(String firstName);
    List<Employee> searchByFirstNameAndOrderAsc();
    List<Employee> searchByFirstNameAndOrderDesc();

}
