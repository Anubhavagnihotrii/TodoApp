package com.example.todoapp.Service.Interface;

import com.example.todoapp.Entity.TodoList;
public interface TodoService {
    TodoList save(TodoList todoList );
    void delete(Long id);
}
