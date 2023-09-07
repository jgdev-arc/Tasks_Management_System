package com.horizon.tasksmanagement.controller;

import com.horizon.tasksmanagement.dto.TaskDTO;
import com.horizon.tasksmanagement.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/tasks")
@AllArgsConstructor
public class TaskController {

    private TaskService taskService;

    //add task rest api
    @PostMapping
    public ResponseEntity<TaskDTO> addTask(@RequestBody TaskDTO taskDTO) {
        TaskDTO savedTask = taskService.addTask(taskDTO);

        return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
    }
}
