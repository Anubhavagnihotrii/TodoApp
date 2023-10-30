package com.example.todoapp.Controller;

import com.example.todoapp.Entity.TodoList;
import com.example.todoapp.Repository.TodoRepository;
import com.example.todoapp.Service.Interface.TodoService;
import jakarta.persistence.GeneratedValue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class TodoController {

    @Autowired
    TodoService todoService;
    @Autowired
    TodoRepository todoRepository;

    @PostMapping("/add")
    public TodoList save(@RequestBody TodoList todoList )
    {
        log.info("inside save method");
        return  todoService.save(todoList);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id)
    {
        log.info("inside delete method");
        todoService.delete(id);
        return ResponseEntity.ok("User deleted");
    }
}
