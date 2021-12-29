package com.akshitbaunthy.restapiassignmentsolution.controller;

import com.akshitbaunthy.restapiassignmentsolution.entity.User;
import com.akshitbaunthy.restapiassignmentsolution.service.UserCreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user/create")
public class UserCreateController {

    UserCreateService userCreateService;

    @Autowired
    private UserCreateController(UserCreateService userCreateService) {
        this.userCreateService = userCreateService;
    }

    @PostMapping("/single")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User createdUser = userCreateService.addUser(user);
        return new ResponseEntity<User>(createdUser, HttpStatus.OK);
    }

    @PostMapping("/bulk")
    public ResponseEntity<List<User>> addEmployees(@RequestBody List<User> users) {
        List<User> createdUsers = userCreateService.addUsers(users);
        return new ResponseEntity<List<User>>(createdUsers, HttpStatus.OK);
    }

}
