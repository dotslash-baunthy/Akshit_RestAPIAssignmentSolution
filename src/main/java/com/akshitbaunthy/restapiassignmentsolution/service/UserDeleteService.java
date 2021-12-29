package com.akshitbaunthy.restapiassignmentsolution.service;

import org.springframework.stereotype.Service;

@Service
public interface UserDeleteService {

    void deleteById(Integer id);

    void deleteAll();

}
