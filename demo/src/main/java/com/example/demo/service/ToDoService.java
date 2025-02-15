package com.example.demo.service;

import com.example.demo.dto.ToDoDTO;
import com.example.demo.dto.request.ToDoRequestDTO;
import com.example.demo.dto.request.ToDoupdateRequestDTO;

import java.util.List;

public interface ToDoService  {
    String addToDo(ToDoRequestDTO toDoRequestDTO);

    List<ToDoDTO> getAllToDo();

    ToDoupdateRequestDTO updateToDo(Long id, ToDoupdateRequestDTO toDoupdateRequestDTO);

    ToDoDTO getToDoById(Long id);

    ToDoDTO markToDoAsCompleted(Long id);

    String deleteToDo(long id);

    List<ToDoDTO> getToDoByCompleted(boolean b);

    List<ToDoDTO> getToDoByTitle(String title) throws ClassNotFoundException;
}
