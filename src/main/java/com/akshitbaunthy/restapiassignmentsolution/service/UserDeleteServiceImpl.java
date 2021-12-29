package com.akshitbaunthy.restapiassignmentsolution.service;

import com.akshitbaunthy.restapiassignmentsolution.entity.User;
import com.akshitbaunthy.restapiassignmentsolution.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDeleteServiceImpl implements UserDeleteService {

    UserRepository deleteRepository;

    @Autowired
    private UserDeleteServiceImpl(UserRepository userRepository) {
        this.deleteRepository = userRepository;
    }

    @Override
    public void deleteById(Integer id) {
        deleteRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        deleteRepository.deleteAll();
    }
}
