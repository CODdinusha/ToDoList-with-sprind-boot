package com.example.demo.ToDoList.controller;

import com.example.demo.ToDoList.dto.request.ToDoUpdateDTO;
import com.example.demo.ToDoList.repo.ToDoRepo;
import com.example.demo.ToDoList.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/toDo")
public class ToDoController {
    @Autowired
    private ToDoService customerService;
    @Autowired
    private ToDoRepo customerRepo;

    @PostMapping
    public String saveCustomer(@RequestBody ToDoUpdateDTO toDoUpdateDTO){
        ToDoService.addToDo(toDoUpdateDTO);
        return null;
    }

}
