package com.a29340.kantastic.controller;

import com.a29340.kantastic.dto.BoardDTO;
import com.a29340.kantastic.dto.mapper.BoardMapper;
import com.a29340.kantastic.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {

    @Autowired
    BoardRepository repo;

    @Autowired
    BoardMapper mapper;

    @GetMapping("/board/{id}")
    public BoardDTO getBoard(@PathVariable Long id) {
        return mapper.boardToBoardDTO(repo.findById(id).get());
    }

}
