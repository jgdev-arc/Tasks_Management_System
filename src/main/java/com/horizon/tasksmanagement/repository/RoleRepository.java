package com.horizon.tasksmanagement.repository;

import com.horizon.tasksmanagement.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
