package com.a29340.kantastic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Board {

    @Id
    private Long id;
    private String name;
    private String description;

}
