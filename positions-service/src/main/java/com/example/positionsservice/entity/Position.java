package com.example.positionsservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Position {
    @Id
    private Integer id;
    private String name;
}
