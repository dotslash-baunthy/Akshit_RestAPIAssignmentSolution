package com.akshitbaunthy.restapiassignmentsolution.service;

import com.akshitbaunthy.restapiassignmentsolution.entity.User;
import com.akshitbaunthy.restapiassignmentsolution.repository.RoleRepository;
import com.akshitbaunthy.restapiassignmentsolution.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

// This service class does the actual user creation
@Service
public class UserCreateServiceImpl implements UserCreateService {

    UserRepository createRepository;
    BCryptPasswordEncoder bCryptPasswordEncoder;

    //    Constructor injection
    @Autowired
    private void userCreateService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.createRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    //    Add a single user
    @Override
    public User addUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return createRepository.save(user);
    }

    //    Add users in bulk
    @Override
    public List<User> addUsers(List<User> users) {
        for (User user : users) {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        }
        return createRepository.saveAll(users);
    }
}
