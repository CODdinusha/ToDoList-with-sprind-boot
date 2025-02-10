package com.example.demo.ToDoList.service.impl;

import com.example.demo.ToDoList.dto.request.ToDoSaveDTO;
import com.example.demo.ToDoList.entity.ToDo;
import com.example.demo.ToDoList.repo.ToDoRepo;
import com.example.demo.ToDoList.service.ToDoService;
import com.example.demo.ToDoList.util.mappers.ToDoMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ToDoServiceIMPL implements ToDoService {

    @Autowired
    private ToDoRepo todoRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ToDoMapper toDoMapping;

    @Override
    public String addToDo(ToDoSaveDTO toDoSaveDTO) {
       ToDo toDo = new ToDo();

       toDo.setTitle(toDoSaveDTO.getTitle());
       toDo.setDescription(toDoSaveDTO.getDescription());
       toDo.setCompleted(toDoSaveDTO.isCompleted());

       if(!todoRepo.existsById(toDo.getId())) {
           todoRepo.save(toDo);
           return toDo.getTitle() + "saved";
       } else {
           System.out.println("Name allready exist ");
           return "Name allready exist";
       }
    }

}
