package com.akshitbaunthy.restapiassignmentsolution.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.akshitbaunthy.restapiassignmentsolution.repository.UserRepository;
import com.akshitbaunthy.restapiassignmentsolution.entity.User;
import com.akshitbaunthy.restapiassignmentsolution.security.MyUserDetails;

public class UserDetailsServiceImpl implements UserDetailsService {

    public UserDetailsServiceImpl() {
    }

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    UserDetailsServiceImpl(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getUserByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        return new MyUserDetails(user);
    }

}