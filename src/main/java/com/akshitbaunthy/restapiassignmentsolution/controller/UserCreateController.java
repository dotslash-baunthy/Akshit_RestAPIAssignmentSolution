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
// ServiceImpl does the actual job. The controller only exposes endpoints
public class UserCreateController {

    UserCreateService userCreateService;

    //    Constructor injection
    @Autowired
    private UserCreateController(UserCreateService userCreateService) {
        this.userCreateService = userCreateService;
    }

    //    Create a single user (body provided in REST API client)
    @PostMapping("/single")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User createdUser = userCreateService.addUser(user);
        return new ResponseEntity<User>(createdUser, HttpStatus.OK);
    }

    //    Create multiple users (body is an array of Employee objects, provided in REST API client)
    @PostMapping("/bulk")
    public ResponseEntity<List<User>> addEmployees(@RequestBody List<User> users) {
        List<User> createdUsers = userCreateService.addUsers(users);
        return new ResponseEntity<List<User>>(createdUsers, HttpStatus.OK);
    }

}
