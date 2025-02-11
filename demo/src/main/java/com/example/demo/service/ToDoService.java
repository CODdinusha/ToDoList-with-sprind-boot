package com.example.demo.service;

import com.example.demo.dto.ToDoDTO;
import com.example.demo.dto.request.ToDoRequestDTO;
import com.example.demo.dto.request.ToDoupdateRequestDTO;
import com.example.demo.dto.response.ToDoResponseDto;

import java.util.List;

public interface ToDoService  {
    String addToDo(ToDoRequestDTO toDoRequestDTO);

    List<ToDoDTO> getAllToDo();

    ToDoupdateRequestDTO updateToDo(Long id, ToDoupdateRequestDTO toDoupdateRequestDTO);
}
