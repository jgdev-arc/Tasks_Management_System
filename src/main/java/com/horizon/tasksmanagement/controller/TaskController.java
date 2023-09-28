package com.horizon.tasksmanagement.controller;

import com.horizon.tasksmanagement.dto.TaskDTO;
import com.horizon.tasksmanagement.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/tasks")
@AllArgsConstructor
public class TaskController {

    private TaskService taskService;


    @PostMapping
    public ResponseEntity<TaskDTO> addTask(@RequestBody TaskDTO taskDTO) {
        TaskDTO savedTask = taskService.addTask(taskDTO);

        return ResponseEntity.ok(savedTask);
    }

    @GetMapping("{id}")
    public ResponseEntity<TaskDTO> getTask(@PathVariable("id") Long taskId) {
        TaskDTO taskDTO = taskService.getTask(taskId);

        return ResponseEntity.ok(taskDTO);
    }

    @GetMapping
    public ResponseEntity<List<TaskDTO>> getAllTasks() {
        List<TaskDTO> tasks = taskService.getAllTasks();

        return ResponseEntity.ok(tasks);
    }

    @PutMapping("{id}")
    public ResponseEntity<TaskDTO> updateTask(@RequestBody TaskDTO taskDTO, @PathVariable("id") Long taskId) {
        TaskDTO updatedTask = taskService.updateTask(taskDTO, taskId);

        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTask(@PathVariable("id") Long taskId) {
        taskService.deleteTask(taskId);

        return ResponseEntity.ok("Task deleted successfully!");
    }

    @PatchMapping("{id}/complete")
    public ResponseEntity<TaskDTO> completeTask(@PathVariable("id") Long taskId) {
        TaskDTO updatedTask = taskService.completeTask(taskId);
        return ResponseEntity.ok(updatedTask);
    }

    @PatchMapping("{id}/incomplete")
    public ResponseEntity<TaskDTO> incompleteTask(@PathVariable("id") Long taskId) {
        TaskDTO updatedTask = taskService.incompleteTask(taskId);

        return ResponseEntity.ok(updatedTask);
    }

}
