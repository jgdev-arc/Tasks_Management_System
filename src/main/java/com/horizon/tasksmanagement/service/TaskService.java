package com.horizon.tasksmanagement.service;

import com.horizon.tasksmanagement.dto.TaskDTO;

import java.util.List;

public interface TaskService {

    TaskDTO addTask(TaskDTO taskDTO);

    TaskDTO getTask(Long id);

    List<TaskDTO> getAllTasks();

    TaskDTO updateTask(TaskDTO taskDTO, Long id);

    void deleteTask(Long id);

    TaskDTO completeTask(Long id);

    TaskDTO incompleteTask(Long id);
}
