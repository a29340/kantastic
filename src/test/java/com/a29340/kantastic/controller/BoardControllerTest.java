package com.a29340.kantastic.controller;

import com.a29340.kantastic.dto.BoardDTO;
import com.a29340.kantastic.model.Board;
import com.a29340.kantastic.repository.BoardRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
class BoardControllerTest {

    @Autowired
    BoardController controller;

    @Autowired
    BoardRepository repo;

    @BeforeEach
    public void setUp() {
        repo.save(new Board(1L, "Test Board", "TestDescription"));
    }

    @Test
    public void shouldGetBoard() {
        BoardDTO boardDTO = controller.getBoard(1L);
        Assertions.assertEquals(1L, boardDTO.getId());
        Assertions.assertEquals("Test Board", boardDTO.getName());
        Assertions.assertEquals("TestDescription", boardDTO.getDescription());
    }

}