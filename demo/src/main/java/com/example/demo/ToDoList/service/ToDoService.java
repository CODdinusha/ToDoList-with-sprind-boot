package com.example.demo.ToDoList.service;

import com.example.demo.ToDoList.dto.request.ToDoSaveDTO;

public interface ToDoService {


    String addToDo(ToDoSaveDTO toDoSaveDTO);
}
