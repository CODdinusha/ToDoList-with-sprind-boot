package com.example.demo.ToDoList.entity;


import jakarta.persistence.*;
import java.time.LocalDateTime;

    @Entity
    @Table(name = "todo_items")
    public class ToDo {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String title;

        private String description;

        @Column(nullable = false)
        private boolean completed;

        @Column(name = "created_at", updatable = false)
        private LocalDateTime createdAt;

        @Column(name = "updated_at")
        private LocalDateTime updatedAt;
        @PrePersist
        public void prePersist() {
            createdAt = LocalDateTime.now();
            updatedAt = LocalDateTime.now();
        }

        @PreUpdate
        public void preUpdate() {
            updatedAt = LocalDateTime.now();
        }
    }


