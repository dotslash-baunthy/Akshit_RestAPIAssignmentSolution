package com.akshitbaunthy.restapiassignmentsolution.repository;

import com.akshitbaunthy.restapiassignmentsolution.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

//    Derived queries methods

    List<Employee> findByFirstNameContainsAllIgnoreCase(String firstName);

    List<Employee> findAllByOrderByFirstNameAsc();

    List<Employee> findAllByOrderByFirstNameDesc();

}
