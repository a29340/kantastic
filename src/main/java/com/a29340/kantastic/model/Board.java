package com.a29340.kantastic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Board {

    @Id
    private Long id;
    private String name;
    private String description;

    public Board() {
    }

    public Board(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
