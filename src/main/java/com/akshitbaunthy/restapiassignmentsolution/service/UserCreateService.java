package com.akshitbaunthy.restapiassignmentsolution.service;

import com.akshitbaunthy.restapiassignmentsolution.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserCreateService {
    User addUser(User user);
    List<User> addUsers(List<User> users);
}
