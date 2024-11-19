package com.example.recommendationservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Recommendation {
    @Id
    private Integer id;
    private String fullname;
    private Integer companyId;
    private Integer positionId;
    private String recommendation;
}
