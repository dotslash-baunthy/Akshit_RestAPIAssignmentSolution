package com.akshitbaunthy.restapiassignmentsolution.service;

import com.akshitbaunthy.restapiassignmentsolution.entity.Employee;
import com.akshitbaunthy.restapiassignmentsolution.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeReadServiceImpl implements EmployeeReadService {

    EmployeeRepository readRepository;

    @Autowired
    private EmployeeReadServiceImpl(EmployeeRepository employeeRepository) {
        this.readRepository = employeeRepository;
    }

    @Override
    public Optional<Employee> getById(Integer id) {
        return readRepository.findById(id);
    }

    @Override
    public List<Employee> getAll() {
        return readRepository.findAll();
    }

    @Override
    public List<Employee> searchByFirstName(String firstName) {
        return readRepository.findByFirstNameContainsAllIgnoreCase(firstName);
    }

    @Override
    public List<Employee> searchByFirstNameAndOrderAsc() {
        return readRepository.findAllByOrderByFirstNameAsc();
    }

    @Override
    public List<Employee> searchByFirstNameAndOrderDesc() {
        return readRepository.findAllByOrderByFirstNameDesc();
    }
}
