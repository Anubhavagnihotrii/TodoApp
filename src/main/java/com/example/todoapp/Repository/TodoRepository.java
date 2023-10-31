package com.example.todoapp.Repository;

import com.example.todoapp.Entity.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<TodoList,Long> {
    boolean findAllById(Long id);
}
