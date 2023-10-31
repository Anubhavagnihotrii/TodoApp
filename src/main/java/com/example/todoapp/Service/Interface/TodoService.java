package com.example.todoapp.Service.Interface;

import com.example.todoapp.Entity.TodoList;

import java.util.List;
import java.util.Optional;

public interface TodoService {
    TodoList save(TodoList todoList );
    void delete(Long id);

    List<TodoList> showTodo();

    Optional<TodoList> showTodoById(Long id);
}
