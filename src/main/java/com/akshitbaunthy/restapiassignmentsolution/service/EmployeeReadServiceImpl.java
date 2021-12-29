package com.akshitbaunthy.restapiassignmentsolution.service;

import com.akshitbaunthy.restapiassignmentsolution.entity.Employee;
import com.akshitbaunthy.restapiassignmentsolution.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

// This service class does the actual employee reading (search, sort, get)
@Service
public class EmployeeReadServiceImpl implements EmployeeReadService {

    EmployeeRepository readRepository;

    //    Constructor injection
    @Autowired
    private EmployeeReadServiceImpl(EmployeeRepository employeeRepository) {
        this.readRepository = employeeRepository;
    }

    //    Get a single employee
    @Override
    public Optional<Employee> getById(Integer id) {
        return readRepository.findById(id);
    }

    //    Get all employees
    @Override
    public List<Employee> getAll() {
        return readRepository.findAll();
    }

    //    Search all employees with first name as String firstName
    @Override
    public List<Employee> searchByFirstName(String firstName) {
        return readRepository.findByFirstNameContainsAllIgnoreCase(firstName);
    }

    //    List all employees and sort in ascending (by firstName)
    @Override
    public List<Employee> searchByFirstNameAndOrderAsc() {
        return readRepository.findAllByOrderByFirstNameAsc();
    }

    //    List all employees and sort in descending (by firstName)
    @Override
    public List<Employee> searchByFirstNameAndOrderDesc() {
        return readRepository.findAllByOrderByFirstNameDesc();
    }
}
