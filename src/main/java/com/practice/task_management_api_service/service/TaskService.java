package com.practice.task_management_api_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.practice.task_management_api_service.entity.Task;
import com.practice.task_management_api_service.repository.TaskRepository;

import jakarta.validation.Valid;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);    
    }  

}
