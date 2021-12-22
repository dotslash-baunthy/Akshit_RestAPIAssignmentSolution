package com.akshitbaunthy.restapiassignmentsolution.repository;

import com.akshitbaunthy.restapiassignmentsolution.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
}
