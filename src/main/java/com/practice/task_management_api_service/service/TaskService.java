package com.practice.task_management_api_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.practice.task_management_api_service.entity.Task;
import com.practice.task_management_api_service.exception.NotFoundException;
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

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new NotFoundException("Task not found with ID: "+id));
    }  

}
