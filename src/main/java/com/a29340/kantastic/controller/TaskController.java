package com.a29340.kantastic.controller;

import com.a29340.kantastic.dto.TaskDTO;
import com.a29340.kantastic.dto.mapper.TaskMapper;
import com.a29340.kantastic.model.Task;
import com.a29340.kantastic.repository.TaskRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping("/tasks")
    public List<TaskDTO> getTasks(@RequestParam @NonNull Long stageId) {
        List<Task> stages =  repo.findByStageId(stageId);
        return stages.stream().map(mapper::taskToTaskDTO).toList();
    }

    @PostMapping("/task")
    public ResponseEntity<TaskDTO> createTask(@RequestBody @Valid TaskDTO taskDTO) {
        Task task = mapper.taskDTOToTask(taskDTO);
        Task saved = repo.save(task);
        return ResponseEntity.ok(mapper.taskToTaskDTO(saved));
    }

    @DeleteMapping("/task/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id) {
        repo.deleteById(id);
        return ResponseEntity.ok().build();
    }

}