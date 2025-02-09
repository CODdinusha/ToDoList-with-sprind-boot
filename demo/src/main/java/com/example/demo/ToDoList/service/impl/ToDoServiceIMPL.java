package com.example.demo.ToDoList.service.impl;

import com.example.demo.ToDoList.entity.ToDo;
import com.example.demo.ToDoList.repo.ToDoRepo;
import com.example.demo.ToDoList.service.ToDoService;
import com.example.demo.ToDoList.util.mappers.ToDoMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoServiceIMPL implements ToDoService {

    @Autowired
    private ToDoRepo todoRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ToDoMapper toDoMapping;
}
