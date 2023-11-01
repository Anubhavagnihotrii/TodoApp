package com.example.todoapp.Service.Impl;

import com.example.todoapp.Entity.TodoList;
import com.example.todoapp.Repository.TodoRepository;
import com.example.todoapp.Service.Interface.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class TodoServiceImpl implements TodoService {
    @Autowired
    TodoRepository todoRepository;
    @Override
    public TodoList save(TodoList todoList) {
         todoRepository.save(todoList);
         return todoList;
    }

    @Override
    public void delete(Long id) {todoRepository.deleteById(id);}

    @Override
    public List<TodoList> showTodo() {
        return todoRepository.findAll();
    }

    @Override
    public Optional<TodoList> showTodoById(Long id) {
        return todoRepository.findById(id);
    }

    @Override
    public TodoList update(Long id, TodoList updatedTodoList) {
        Optional<TodoList> todoOptional = todoRepository.findById(id);
        if(todoOptional.isPresent())
        {
          TodoList todoList = todoOptional.get();
          todoList.setTitle(updatedTodoList.getTitle());
          todoList.setNote(updatedTodoList.getNote());

          todoRepository.save(todoList);
          return  todoList;
        }
        else {
            throw new IllegalArgumentException("TodoList not found");
        }
    }


}
