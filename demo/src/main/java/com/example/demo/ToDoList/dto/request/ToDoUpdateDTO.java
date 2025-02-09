package com.example.demo.ToDoList.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor@Data
public class ToDoUpdateDTO {
    private String title;
    private String description;


}
