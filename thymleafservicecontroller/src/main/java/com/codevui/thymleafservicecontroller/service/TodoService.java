package com.codevui.thymleafservicecontroller.service;

import java.util.List;

import com.codevui.thymleafservicecontroller.model.Todo;

public interface TodoService {
    public void addToDo(String title);

    public List<Todo> getAllToDo();

    public void deleteTodo(int id);

    public void toggleTodo(int id);

    
}
