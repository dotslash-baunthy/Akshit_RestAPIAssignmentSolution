package com.akshitbaunthy.restapiassignmentsolution.controller;

import com.akshitbaunthy.restapiassignmentsolution.entity.Employee;
import com.akshitbaunthy.restapiassignmentsolution.service.EmployeeReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee/read")
// ServiceImpl does the actual job. The controller only exposes endpoints
public class EmployeeReadController {

    EmployeeReadService employeeReadService;

    //    Constructor injection
    @Autowired
    private EmployeeReadController(EmployeeReadService employeeReadService) {
        this.employeeReadService = employeeReadService;
    }

    //    Read a single employee (ID provided as path variable)
//    If Employee exists, return employee, else return not found
    @GetMapping("/single/{id}")
    public ResponseEntity<Optional<Employee>> getById(@PathVariable Integer id) {
        Optional<Employee> fetchedEmployee = employeeReadService.getById(id);
        if (fetchedEmployee.isPresent()) {
            return new ResponseEntity<Optional<Employee>>(fetchedEmployee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //    Read all employees
    @GetMapping("/bulk")
    public ResponseEntity<List<Employee>> getAll() {
        List<Employee> fetchedEmployees = employeeReadService.getAll();
        return new ResponseEntity<List<Employee>>(fetchedEmployees, HttpStatus.OK);
    }

    //    Search employees with given first name (String given as path variable)
    @GetMapping("/search/{firstName}")
    public ResponseEntity<List<Employee>> search(@PathVariable String firstName) {
        List<Employee> fetchedEmployees = employeeReadService.searchByFirstName(firstName);
        return new ResponseEntity<List<Employee>>(fetchedEmployees, HttpStatus.OK);
    }

    //    Sort employees in given order (order asc or desc given as request parameter)
    @GetMapping("/sort")
    public ResponseEntity<List<Employee>> sort(@RequestParam String order) {
        List<Employee> fetchedEmployees;
        if (order.toLowerCase().equals("desc")) {
            fetchedEmployees = employeeReadService.searchByFirstNameAndOrderDesc();
        } else {
            fetchedEmployees = employeeReadService.searchByFirstNameAndOrderAsc();
        }
        return new ResponseEntity<List<Employee>>(fetchedEmployees, HttpStatus.OK);
    }
}
