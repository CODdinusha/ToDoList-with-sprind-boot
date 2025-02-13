package com.example.demo.util.mapper;

import com.example.demo.dto.ToDoDTO;
import com.example.demo.dto.request.ToDoupdateRequestDTO;
import com.example.demo.entity.ToDo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ToDoMapper {

    ToDoupdateRequestDTO entityToDto(ToDo toDo);

    ToDoDTO entityToDTO(ToDo toDo);
}
