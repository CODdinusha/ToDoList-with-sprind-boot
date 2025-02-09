package com.example.demo.ToDoList.util.mappers;

import com.example.demo.ToDoList.dto.ToDoDTO;
import com.example.demo.ToDoList.entity.ToDo;
import org.mapstruct.Mapper;

import java.util.List;


    @Mapper(componentModel = "spring")
    public interface ToDoMapper {
        ToDoDTO entityToDto(ToDo toDo);






        //    List<CustomerDTO> entityListToDtoList(List<Customer> customers);
        List<ToDoDTO> entityListToDtoList(List<ToDo> toDoList);

    }


