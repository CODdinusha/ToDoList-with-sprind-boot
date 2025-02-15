package com.example.demo.repo;

import com.example.demo.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories

public interface ToDoRepo extends JpaRepository<ToDo, Long> {
    List<ToDo> findAllByCompletedEquals(boolean b);

    List<ToDo> findAllByTitleEquals(String title);
}
