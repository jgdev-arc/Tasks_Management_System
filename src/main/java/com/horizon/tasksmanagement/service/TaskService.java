package com.horizon.tasksmanagement.service;

import com.horizon.tasksmanagement.dto.TaskDTO;

import java.util.List;

public interface TaskService {

    TaskDTO addTask(TaskDTO taskDTO);

    TaskDTO getTask(Long id);

    List<TaskDTO> getAllTasks();
}
