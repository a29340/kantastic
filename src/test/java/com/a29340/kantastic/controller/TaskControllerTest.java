package com.a29340.kantastic.controller;

import com.a29340.kantastic.dto.TaskDTO;
import com.a29340.kantastic.model.Task;
import com.a29340.kantastic.repository.TaskRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootTest
@Transactional
class TaskControllerTest {

    @Autowired
    TaskController controller;

    @Autowired
    TaskRepository repo;

    @BeforeEach
    public void setUp() {
        repo.save(new Task(1L, "Test Task", "Test Description", 0L));
        repo.save(new Task(2L, "Test Task2", "Test Description2", 0L));
        repo.save(new Task(3L, "Test Task3", "Test Description3", 1L));
    }

    @Test
    public void shouldGetTask() {
        TaskDTO taskDTO = controller.getTask(1L);
        Assertions.assertEquals(1L, taskDTO.getId());
        Assertions.assertEquals("Test Task", taskDTO.getName());
        Assertions.assertEquals("Test Description", taskDTO.getDescription());
        Assertions.assertEquals(0L, taskDTO.getStageId());
    }

    @Test
    public void shouldGetTaskFromStageId() {
        List<TaskDTO> taskDTOs = controller.getTasks(0L);
        Assertions.assertEquals(2, taskDTOs.size());
        Assertions.assertEquals(0L, taskDTOs.get(0).getStageId());
    }


    @Test
    void shouldCreateTask() {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(10L);
        taskDTO.setDescription("Test Description");
        taskDTO.setName("Test Task");
        taskDTO.setStageId(5L);
        ResponseEntity<TaskDTO> response = controller.createTask(taskDTO);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(10L, response.getBody().getId());
    }
}