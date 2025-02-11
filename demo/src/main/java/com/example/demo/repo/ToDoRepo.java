package com.example.demo.repo;

import com.example.demo.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories

public interface ToDoRepo extends JpaRepository<ToDo, Long> {
}
