package com.example.demo.controller;


import com.example.demo.dto.ToDoDTO;
import com.example.demo.dto.request.ToDoRequestDTO;
import com.example.demo.dto.request.ToDoupdateRequestDTO;
import com.example.demo.dto.response.ToDoResponseDto;
import com.example.demo.repo.ToDoRepo;
import com.example.demo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/toDo/")
public class ToDoController  {
    @Autowired
    private ToDoService toDoService;

    @PostMapping("/save")
    public ResponseEntity<String> saveToDo(@RequestBody ToDoRequestDTO toDoRequestDTO) {
        String result = toDoService.addToDo(toDoRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
    @GetMapping(
            path = "/todos/all")

    public List<ToDoDTO> getAllToDo(){
        List<ToDoDTO> allToDo = toDoService.getAllToDo();
        return allToDo;
    }
//    @PutMapping(path = "/update/{id}")
//    public String updateToDO(@RequestBody ToDoupdateRequestDTO) {
//        String updated = toDoService.updateToDO(ToDoupdateRequestDTO);
//        return updated;
//    }
    @PutMapping("/todos/{id}")
    public ResponseEntity<ToDoupdateRequestDTO> updateToDo(@PathVariable Long id, @RequestBody ToDoupdateRequestDTO toDoupdateRequestDTO) {
        ToDoupdateRequestDTO updatedToDo = toDoService.updateToDo(id, toDoupdateRequestDTO);
        return ResponseEntity.ok(updatedToDo);


    }




}


