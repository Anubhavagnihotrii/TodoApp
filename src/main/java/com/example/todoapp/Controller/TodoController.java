package com.example.todoapp.Controller;

import com.example.todoapp.Entity.TodoList;
import com.example.todoapp.Repository.TodoRepository;
import com.example.todoapp.Service.Interface.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        Optional<TodoList> b =todoRepository.findById(id);
        if(b.isPresent()){
        todoService.delete(id);
        return ResponseEntity.ok("Notes Deleted");}
        else
        {
            return ResponseEntity.ok("Notes doesn't exists.");
        }
    }

    @GetMapping("showAll")
    public List<TodoList> showTodo()
    {
        return todoService.showTodo();
    }

   @GetMapping("show/{id}")
    public Optional<TodoList>showById( @PathVariable Long id)
   {
       return todoService.showTodoById(id);
   }
}
