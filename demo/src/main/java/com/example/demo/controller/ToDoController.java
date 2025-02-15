package com.example.demo.controller;


import com.example.demo.dto.ToDoDTO;
import com.example.demo.dto.request.ToDoRequestDTO;
import com.example.demo.dto.request.ToDoupdateRequestDTO;
import com.example.demo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/toDo/")
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @PostMapping("/save")
    public ResponseEntity<String> saveToDo(@RequestBody ToDoRequestDTO toDoRequestDTO) {
        String result = toDoService.addToDo(toDoRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping(
            path = "/todos/all")

    public List<ToDoDTO> getAllToDo() {
        List<ToDoDTO> allToDo = toDoService.getAllToDo();
        return allToDo;
    }
    @PutMapping("/todos/{id}")
    public ResponseEntity<ToDoupdateRequestDTO> updateToDo(@PathVariable Long id, @RequestBody ToDoupdateRequestDTO toDoupdateRequestDTO) {
        ToDoupdateRequestDTO updatedToDo = toDoService.updateToDo(id, toDoupdateRequestDTO);
        return ResponseEntity.ok(updatedToDo);
    }

    @GetMapping("/todos/{id}")
    public ResponseEntity<ToDoDTO> getToDoById(@PathVariable Long id) {
        ToDoDTO toDo = toDoService.getToDoById(id);
        return ResponseEntity.ok(toDo);
    }
    @PatchMapping("/todos/{id}/complete")
    public ResponseEntity<ToDoDTO> markToDoAsCompleted(@PathVariable Long id) {
        ToDoDTO updatedToDo = toDoService.markToDoAsCompleted(id);
        return ResponseEntity.ok(updatedToDo);
    }
    @DeleteMapping(path = "/delete-todo/{id}")
    public String deleteToDo(@PathVariable("id") long id) {

        return toDoService.deleteToDo(id);
    }
    @GetMapping(path = "/complete-todo")
    public ResponseEntity<List<ToDoDTO>> getCompletedToDo() {
        List<ToDoDTO> toDoDTOList = toDoService.getToDoByCompleted(true);
        return ResponseEntity.ok(toDoDTOList);
    }

    @GetMapping(
            path = {"/get-by-title"},
            params = {"title"}
    )
    public ResponseEntity<List<ToDoDTO>> getByTitle(@RequestParam(value = "title") String title) throws ClassNotFoundException {
        List<ToDoDTO> toDoDTOList = toDoService.getToDoByTitle(title);
        return ResponseEntity.ok(toDoDTOList);
    }

}


