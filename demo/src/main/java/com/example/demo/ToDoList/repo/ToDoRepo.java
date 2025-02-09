package com.example.demo.ToDoList.repo;

import com.example.demo.ToDoList.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepo extends JpaRepository<ToDo, Integer> {
}
