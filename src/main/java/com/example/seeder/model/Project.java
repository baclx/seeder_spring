package com.example.seeder.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    @Id
    @GeneratedValue
    private Long id;

    private String description;

    private String name;

    private Double stage;

    public Project(String description, String name, Double stage) {
        this.description = description;
        this.name = name;
        this.stage = stage;
    }
}
