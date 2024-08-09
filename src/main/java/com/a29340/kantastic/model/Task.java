package com.a29340.kantastic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Task {
    @Id
    private Long id;

    private String name;
    private String description;
    private Long stageId;
    private Long boardId;

    public Task() {
    }

    public Task(Long id, String name, String description, Long stageId, Long boardId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.stageId = stageId;
        this.boardId = boardId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String title) {
        this.name = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getStageId() {
        return stageId;
    }

    public void setStageId(Long stageId) {
        this.stageId = stageId;
    }

    public Long getBoardId() {
        return boardId;
    }

    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }
}
