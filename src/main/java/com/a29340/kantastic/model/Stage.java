package com.a29340.kantastic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Stage {

    @Id
    private Long id;
    private String name;
    private String description;
    private Long boardId;

    public Stage() {
    }

    public Stage(Long id, String name, String description, Long boardId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.boardId = boardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getBoardId() {
        return boardId;
    }

    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
