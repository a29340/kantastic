package com.a29340.kantastic.controller;

import com.a29340.kantastic.dto.StageDTO;
import com.a29340.kantastic.model.Stage;
import com.a29340.kantastic.repository.StageRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Transactional
class StageControllerTest {

    @Autowired
    StageController controller;

    @Autowired
    StageRepository repo;

    @BeforeEach
    public void setUp() {
        repo.save(new Stage(1L, "Test Stage", "Test Description", 0L));
        repo.save(new Stage(2L, "Test Stage2", "Test Description2", 0L));
        repo.save(new Stage(3L, "Test Stage3", "Test Description3", 1L));
    }

    @Test
    public void shouldGetStage() {
        StageDTO stageDTO = controller.getStage(1L);
        Assertions.assertEquals(1L, stageDTO.getId());
        Assertions.assertEquals("Test Stage", stageDTO.getName());
        Assertions.assertEquals("Test Description", stageDTO.getDescription());
        Assertions.assertEquals(0L, stageDTO.getBoardId());
    }

    @Test
    public void shouldGetStagesWithBoardId() {
        List<StageDTO> stageDTO = controller.getStages(0L);
        Assertions.assertEquals(2, stageDTO.size());
        Assertions.assertEquals(0L, stageDTO.get(0).getBoardId());
    }


}