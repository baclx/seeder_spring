package com.example.seeder.model;

import com.github.javafaker.DateAndTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String category;
    private Long qty;
    private Date createdAt;
    private Date updatedAt;

    public Product(String name, String category, Long qty, Date createdAt, Date updatedAt) {
        this.name = name;
        this.category = category;
        this.qty = qty;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
