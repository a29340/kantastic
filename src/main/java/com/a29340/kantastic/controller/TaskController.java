package com.a29340.kantastic.controller;

import com.a29340.kantastic.dto.TaskDTO;
import com.a29340.kantastic.dto.mapper.TaskMapper;
import com.a29340.kantastic.model.Task;
import com.a29340.kantastic.repository.TaskRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class TaskController {

    private final TaskRepository repo;
    private final TaskMapper mapper;

    public TaskController(TaskMapper mapper, TaskRepository repo) {
        this.mapper = mapper;
        this.repo = repo;
    }

    @GetMapping("/task/{id}")
    public TaskDTO getTask(@PathVariable Long id) {
        Optional<Task> task = repo.findById(id);
        return mapper.taskToTaskDTO(task.orElse(null));
    }

}