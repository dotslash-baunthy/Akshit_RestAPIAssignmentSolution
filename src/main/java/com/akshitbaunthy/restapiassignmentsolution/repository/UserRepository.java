package com.akshitbaunthy.restapiassignmentsolution.repository;

import com.akshitbaunthy.restapiassignmentsolution.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select u from User u where u.username = ?1")
    public User getUserByUsername(String username);
}
