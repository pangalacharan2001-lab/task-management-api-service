package com.practice.task_management_api_service.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.practice.task_management_api_service.entity.Task;
import com.practice.task_management_api_service.exception.NotFoundException;
import com.practice.task_management_api_service.repository.TaskRepository;

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

    public Task updateTaskById(Long id, Task task) {
        Task existingDetails = taskRepository.findById(id).orElseThrow(() -> new NotFoundException("Task Details Not Found For the ID: "+id));
        existingDetails.setTitle(task.getTitle());
        existingDetails.setStatus(task.getStatus());
        existingDetails.setDescription(task.getDescription());
        existingDetails.setPriority(task.getPriority());
        existingDetails.setDueDate(task.getDueDate());
        existingDetails.setCreatedAt(task.getCreatedAt());
        return taskRepository.save(existingDetails);
    }

    public void deleteTaskById(Long id) {
        taskRepository.deleteById(id);
    }     
}
