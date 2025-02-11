package com.example.demo.dto.request;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ToDoupdateRequestDTO {
    private Long id;
    private String title;
    private String description;
    private String content;
    private boolean completed ;
    private LocalDateTime updatedAt;


}
