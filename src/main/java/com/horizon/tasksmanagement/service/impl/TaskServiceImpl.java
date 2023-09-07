package com.horizon.tasksmanagement.service.impl;

import com.horizon.tasksmanagement.dto.TaskDTO;
import com.horizon.tasksmanagement.entity.Task;
import com.horizon.tasksmanagement.exception.ResourceNotFoundException;
import com.horizon.tasksmanagement.repository.TaskRepository;
import com.horizon.tasksmanagement.service.TaskService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public TaskDTO getTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task with ID of: " + id + " not found."));

        return modelMapper.map(task, TaskDTO.class);
    }

    @Override
    public List<TaskDTO> getAllTasks() {

        List<Task> tasks = taskRepository.findAll();

        return tasks.stream().map((task) -> modelMapper.map(task, TaskDTO.class))
                .collect(Collectors.toList());
    }
}
