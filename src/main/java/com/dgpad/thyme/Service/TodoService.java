package com.dgpad.thyme.Service;


import com.dgpad.thyme.Model.Todo;
import com.dgpad.thyme.Repository.todoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    private todoRepository todoRepository;

    public Todo save(Todo todo){
        return todoRepository.save(todo);
    }
    public Todo getbyID(int id){
        return todoRepository.findById(id).orElse(null);
    }

    public List<Todo> getAll(){
        return todoRepository.findAll();
    }
    public void delete(int id) {
        todoRepository.deleteById(id);
    }
    public Todo markcompleted( int id){
        Todo todo =getbyID(id);
        todo.setCompleted(true);
        return save(todo);
    }
    public Todo edit( int id,String title,String description){
        Todo todo =getbyID(id);
        todo.setTitle(title);
        todo.setDescription(description);
        return save(todo);
    }
}

