package com.a29340.kantastic.controller;

import com.a29340.kantastic.dto.StageDTO;
import com.a29340.kantastic.dto.mapper.StageMapper;
import com.a29340.kantastic.model.Stage;
import com.a29340.kantastic.repository.StageRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
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

}