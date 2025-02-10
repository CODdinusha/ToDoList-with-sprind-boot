package com.example.demo.ToDoList.dto.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ToDoSaveDTO {
    private String title;
    private String description;
    private boolean completed;

}
