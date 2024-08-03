package com.a29340.kantastic.controller;

import com.a29340.kantastic.dto.StageDTO;
import com.a29340.kantastic.dto.mapper.StageMapper;
import com.a29340.kantastic.model.Stage;
import com.a29340.kantastic.repository.StageRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Transactional
public class StageController {

    private final StageRepository repo;
    private final StageMapper mapper;

    public StageController(StageMapper mapper, StageRepository repo) {
        this.mapper = mapper;
        this.repo = repo;
    }

    @GetMapping("/stage/{id}")
    public StageDTO getStage(@PathVariable Long id) {
        Optional<Stage> stage = repo.findById(id);
        return mapper.stageToStageDTO(stage.orElse(null));
    }

    @GetMapping("/stages")
    public List<StageDTO> getStages(@RequestParam @NonNull Long boardId) {
        List<Stage> stages =  repo.findByBoardId(boardId);
        return stages.stream().map(mapper::stageToStageDTO).toList();
    }

    @PostMapping("/stage")
    public ResponseEntity<StageDTO> createStage(@RequestBody @Valid StageDTO stageDTO) {
        Stage stage = mapper.stageDTOToStage(stageDTO);
        Stage saved = repo.save(stage);
        return ResponseEntity.ok(mapper.stageToStageDTO(saved));
    }

    @DeleteMapping("/stage/{id}")
    public ResponseEntity<?> deleteStage(@PathVariable Long id) {
        repo.deleteById(id);
        return ResponseEntity.ok().build();
    }
}