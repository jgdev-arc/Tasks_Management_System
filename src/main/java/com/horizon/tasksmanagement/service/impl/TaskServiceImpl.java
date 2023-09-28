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

    @Override
    public TaskDTO updateTask(TaskDTO taskDTO, Long id) {

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task with ID of: " + id + " not found."));

        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setCompleted(taskDTO.isCompleted());

        Task updatedTask = taskRepository.save(task);

        return modelMapper.map(updatedTask, TaskDTO.class);
    }

    @Override
    public void deleteTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task with ID of: " + id + " not found."));

        taskRepository.deleteById(id);
    }

    @Override
    public TaskDTO completeTask(Long id) {

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task with ID of: " + id + " not found."));

        task.setCompleted(Boolean.TRUE);

        Task updatedTask = taskRepository.save(task);

        return modelMapper.map(updatedTask, TaskDTO.class);
    }

    @Override
    public TaskDTO incompleteTask(Long id) {

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task with ID of: " + id + " not found."));

        task.setCompleted(Boolean.FALSE);

        Task updatedTask = taskRepository.save(task);

        return modelMapper.map(updatedTask, TaskDTO.class);
    }


}
