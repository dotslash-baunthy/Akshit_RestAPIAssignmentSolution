package com.akshitbaunthy.restapiassignmentsolution.service;

import org.springframework.stereotype.Service;

@Service
public interface EmployeeDeleteService {

    String deleteById(Long id);
    String deleteAll();

}
