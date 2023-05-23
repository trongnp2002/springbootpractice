package com.codevui.thymleafservicecontroller.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codevui.thymleafservicecontroller.model.Todo;

@Repository
public interface ToDoRepository extends JpaRepository<Todo, Integer>{
    

    
    
}
