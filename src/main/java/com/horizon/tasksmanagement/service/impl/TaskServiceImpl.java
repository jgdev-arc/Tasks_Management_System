package com.horizon.tasksmanagement.service.impl;

import com.horizon.tasksmanagement.dto.TaskDTO;
import com.horizon.tasksmanagement.entity.Task;
import com.horizon.tasksmanagement.repository.TaskRepository;
import com.horizon.tasksmanagement.service.TaskService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;

    private ModelMapper modelMapper;

    @Override
    public TaskDTO addTask(TaskDTO taskDTO) {

        Task task = modelMapper.map(taskDTO, Task.class);

        Task savedTask = taskRepository.save(task);

        TaskDTO savedTaskDTO = modelMapper.map(savedTask, TaskDTO.class);


        return savedTaskDTO;
    }
}
