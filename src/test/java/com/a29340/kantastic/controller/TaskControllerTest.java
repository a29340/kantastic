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
    }

    @Test
    public void shouldGetTask() {
        TaskDTO taskDTO = controller.getTask(1L);
        Assertions.assertEquals(1L, taskDTO.getId());
        Assertions.assertEquals("Test Task", taskDTO.getName());
        Assertions.assertEquals("Test Description", taskDTO.getDescription());
        Assertions.assertEquals(0L, taskDTO.getStageId());
    }

}