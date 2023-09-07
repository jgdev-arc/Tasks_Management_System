package com.horizon.tasksmanagement.repository;

import com.horizon.tasksmanagement.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
