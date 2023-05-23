package com.codevui.thymleafservicecontroller.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.codevui.thymleafservicecontroller.model.Todo;
import com.codevui.thymleafservicecontroller.service.TodoService;

@Controller
public class MainController {
    @Autowired
    TodoService toDoService;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/list-todo")
    public String listTodo(Model model) {
        List<Todo> list = toDoService.getAllToDo();
        model.addAttribute("listTodo", list);
        return "todo/listToDo";
    }

    @PostMapping(value = "/add-todo")
    public String addTodo(HttpServletRequest request) {
        String title = request.getParameter("title");
        toDoService.addToDo(title);
        return "redirect:/list-todo";
    }

    @GetMapping(value = "/delete-todo")
    public String deleteTodo(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        toDoService.deleteTodo(id);
        return "redirect:/list-todo";

    }

    @GetMapping(value = "/complete-todo")
    public String ToggleTodo(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        toDoService.toggleTodo(id);
        return "redirect:/list-todo";

    }

}
