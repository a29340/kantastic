package com.a29340.kantastic.controller;

import com.a29340.kantastic.dto.BoardDTO;
import com.a29340.kantastic.dto.mapper.BoardMapper;
import com.a29340.kantastic.model.Board;
import com.a29340.kantastic.repository.BoardRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Transactional
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

    @PostMapping("/board")
    public ResponseEntity<BoardDTO> createBoard(@RequestBody @Valid BoardDTO boardDTO) {
        Board board = mapper.boardDTOToBoard(boardDTO);
        Board saved = repo.save(board);
        return ResponseEntity.ok(mapper.boardToBoardDTO(saved));
    }

    @DeleteMapping("/board/{id}")
    public ResponseEntity<?> deleteBoard(@PathVariable Long id) {
        repo.deleteById(id);
        return ResponseEntity.ok().build();
    }

}