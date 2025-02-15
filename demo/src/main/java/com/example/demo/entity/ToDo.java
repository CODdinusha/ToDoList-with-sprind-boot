package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "todos")
@AllArgsConstructor
@NoArgsConstructor
@Data

    public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false,unique = true)
        private Long id;
    @Column(name = "title",nullable = false)
    private String title;
    @Column(name = "description",nullable = false)
        private String description;
    @Column(name = "content",nullable = false)
        private String content;
    @Column(nullable = true)
    private boolean completed = false;

    @Column(updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt;

    @PreUpdate
    public void setUpdatedAt() {
        this.updatedAt = LocalDateTime.now();
    }
}


