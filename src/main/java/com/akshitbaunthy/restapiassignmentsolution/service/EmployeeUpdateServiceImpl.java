package com.akshitbaunthy.restapiassignmentsolution.service;

import com.akshitbaunthy.restapiassignmentsolution.entity.Employee;
import com.akshitbaunthy.restapiassignmentsolution.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

// The service class does the actual employee updating
@Service
public class EmployeeUpdateServiceImpl implements EmployeeUpdateService {

    EmployeeRepository updateRepository;
    EmployeeRepository readRepository;

    //    Constructor injection
    @Autowired
    private EmployeeUpdateServiceImpl(EmployeeRepository employeeRepository) {
        this.updateRepository = employeeRepository;
        this.readRepository = employeeRepository;
    }

    //    Update employee by ID
//    If Employee with given ID is found, update it else return null
    @Override
    public Employee updateById(Integer id, Employee employee) {
        Optional<Employee> fetchedEmployee = readRepository.findById(id);
        if (fetchedEmployee.isPresent()) {
            Employee tempEmployee = fetchedEmployee.get();
            tempEmployee.setEmail(employee.getEmail());
            tempEmployee.setFirstName(employee.getFirstName());
            tempEmployee.setLastName(employee.getLastName());
            updateRepository.save(tempEmployee);
            return fetchedEmployee.get();
        } else {
            return null;
        }
    }
}
