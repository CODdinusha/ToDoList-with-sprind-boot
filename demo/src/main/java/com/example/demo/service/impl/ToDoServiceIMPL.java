package com.example.demo.service.impl;


import com.example.demo.dto.ToDoDTO;
import com.example.demo.dto.request.ToDoRequestDTO;
import com.example.demo.dto.request.ToDoupdateRequestDTO;
import com.example.demo.entity.ToDo;

import com.example.demo.repo.ToDoRepo;
import com.example.demo.service.ToDoService;
//import com.example.demo.ToDoList.util.mappers.ToDoMapper;
import com.example.demo.util.mapper.ToDoMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ToDoServiceIMPL implements ToDoService {
    @Autowired
    private ToDoMapper toDoMapper;
    @Autowired
    private ToDoRepo toDoRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String addToDo(ToDoRequestDTO toDoRequestDTO) {
        ToDo toDo = new ToDo();  // Create an instance of ToDo
        toDo.setTitle(toDoRequestDTO.getTitle());
        toDo.setDescription(toDoRequestDTO.getDescription());
        toDo.setContent(toDoRequestDTO.getContent());
        toDo.setCompleted(toDoRequestDTO.isCompleted());
        toDoRepo.save(toDo);
        return "Task '" + toDo.getTitle() + "' saved successfully!";
    }

    @Override
    public List<ToDoDTO> getAllToDo() {
        List<ToDo> getToDos = toDoRepo.findAll();
        List<ToDoDTO> toDoDTOList = new ArrayList<>();

        List<ToDoDTO> toDoDTOS = modelMapper.
                map(getToDos, new TypeToken<List<ToDoDTO>>() {
                }.getType());
        return toDoDTOS;
    }

    @Override
    public ToDoupdateRequestDTO updateToDo(Long id, ToDoupdateRequestDTO toDoupdateRequestDTO) {
        Optional<ToDo> toDo = toDoRepo.findById(toDoupdateRequestDTO.getId());

        ToDo toDo1 = toDo.get();

        toDo1.setTitle(toDoupdateRequestDTO.getTitle());
        toDo1.setDescription(toDoupdateRequestDTO.getDescription());
        toDo1.setContent(toDoupdateRequestDTO.getContent());
        toDo1.setCompleted(toDoupdateRequestDTO.isCompleted());

        toDo1.setUpdatedAt(LocalDateTime.now());
        ToDo updatedToDo = toDoRepo.save(toDo1);
        return modelMapper.map(updatedToDo, ToDoupdateRequestDTO.class);
    }

    @Override
    public ToDoDTO getToDoById(Long id) {
        Optional<ToDo> toDo = toDoRepo.findById(id);
        if (toDo.isPresent()) {
            ToDoDTO toDoDTO = toDoMapper.entityToDTO(toDo.get());
            return toDoDTO;
        }else{
            System.out.println("Not Available");
        }
        return null;
    }
    @Override
    public ToDoDTO markToDoAsCompleted(Long id) {
        ToDo toDo = toDoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("ToDo not found with id: " + id));

        toDo.setCompleted(true); // Mark as completed
        toDo.setUpdatedAt(LocalDateTime.now()); // Update timestamp

        ToDo updatedToDo = toDoRepo.save(toDo);
        return toDoMapper.toDto(updatedToDo);
    }

    @Override
    public String deleteToDo(long id) {
        if (toDoRepo.existsById(id)) {
            toDoRepo.deleteById(id);
            return "Customer with ID " + id + " has been deleted successfully.";
        } else {
            return "Customer with ID " + id + " not found. Cannot delete.";
        }
    }

//    @Override
//    public List<ToDoDTO> getToDoByCompleted(boolean b) {
//        List<ToDo> toDos = toDoRepo.findAllByCompletedEquals();
//        return toDoMapper.entityListToDtoList(toDos);
//    }

    @Override
    public List<ToDoDTO> getToDoByCompleted(boolean b) {
        List<ToDo> toDos = toDoRepo.findAllByCompletedEquals(b);
        return toDos.stream() .map(toDo -> modelMapper.map(toDo, ToDoDTO.class))
                .collect(Collectors.toList()); // Use the fixed method
    }

    @Override
    public List<ToDoDTO> getToDoByTitle(String title) throws ClassNotFoundException {
        List<ToDo> toDos = toDoRepo.findAllByTitleEquals(title);
        if(toDos.size() != 0) {
            List<ToDoDTO> toDoDTOS = modelMapper.
                    map(toDos, new TypeToken<List<ToDoDTO>>() {

                    }.getType());
            return toDoDTOS;
        } else {
            throw new ClassNotFoundException("no results");
        }
        }
    }


