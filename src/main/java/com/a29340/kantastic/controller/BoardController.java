package com.a29340.kantastic.controller;

import com.a29340.kantastic.dto.BoardDTO;
import com.a29340.kantastic.dto.mapper.BoardMapper;
import com.a29340.kantastic.model.Board;
import com.a29340.kantastic.repository.BoardRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class BoardController {

    private final BoardRepository repo;
    private final BoardMapper mapper;

    public BoardController(BoardMapper mapper, BoardRepository repo) {
        this.mapper = mapper;
        this.repo = repo;
    }

    @GetMapping("/board/{id}")
    public BoardDTO getBoard(@PathVariable Long id) {
        Optional<Board> board = repo.findById(id);
        return mapper.boardToBoardDTO(board.orElse(null));
    }

}