package com.akshitbaunthy.restapiassignmentsolution.service;

import org.springframework.stereotype.Service;

@Service
public interface EmployeeReadService {

    String getById(Long id);
    String getAll();

}
