package com.akshitbaunthy.restapiassignmentsolution.service;

import org.springframework.stereotype.Service;

@Service
public interface EmployeeDeleteService {

    boolean deleteById(Integer id);
    void deleteAll();

}
