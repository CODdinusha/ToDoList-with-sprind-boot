package com.example.demo.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ToDoDTO {
    private Long id;
    private String title;
    private String description;
    private String content;
    private boolean completed;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ToDoDTO(Long id, String title, String description, String content, boolean completed) {
    }
}


