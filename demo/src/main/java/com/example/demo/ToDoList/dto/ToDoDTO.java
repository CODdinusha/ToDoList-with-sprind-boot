package com.example.demo.ToDoList.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ToDoDTO {
    private int id;
    private String title;
    private String description;
    private boolean completed;
    private LocalDateTime createdAt;

}
