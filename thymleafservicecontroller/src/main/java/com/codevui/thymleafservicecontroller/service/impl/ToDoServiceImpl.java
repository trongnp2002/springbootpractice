package com.codevui.thymleafservicecontroller.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codevui.thymleafservicecontroller.model.Todo;
import com.codevui.thymleafservicecontroller.repository.ToDoRepository;
import com.codevui.thymleafservicecontroller.service.TodoService;

@Service
public class ToDoServiceImpl implements TodoService{
    public static int increase = 0;

    @Autowired
    ToDoRepository toDoRepository;

    @Override
    public void addToDo(String title) {
        Todo todo = Todo.builder().title(title).completed(false).build();// khong truyen id => tao moi, neu truyen => update
        toDoRepository.save(todo);
    }

    @Override
    public List<Todo> getAllToDo() {
        return toDoRepository.findAll();
    }
    @Override

    public void deleteTodo(int id) {
        toDoRepository.deleteById(id);;
    }

    @Override
    public void toggleTodo(int id) {
        Todo oldTodo = toDoRepository.findById(id).get();
        oldTodo.setCompleted(!oldTodo.isCompleted());
        toDoRepository.save(oldTodo);
    }

}
