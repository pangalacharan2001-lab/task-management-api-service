package com.practice.task_management_api_service.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.practice.task_management_api_service.entity.Task;
import com.practice.task_management_api_service.service.TaskService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private TaskService taskService;

    
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @GetMapping
    public List<Task> getAllTasks()
    {
        return taskService.getAllTasks();
    }  
    
    @PostMapping
    public Task createTask(@Valid @RequestBody Task task){
        return taskService.createTask(task);
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id)
    {
        return taskService.getTaskById(id);
    }

    @PutMapping("/{id}")
    public Task updateTaskById(@PathVariable Long id, @Valid @RequestBody Task task)
    {
        return taskService.updateTaskById(id, task);
    }

    @DeleteMapping("/{id}")
    public void deleteTaskById(@PathVariable Long id){
        taskService.deleteTaskById(id);
    }
}
