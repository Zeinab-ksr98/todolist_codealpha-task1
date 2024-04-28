package com.dgpad.thyme.Controller;

import com.dgpad.thyme.Model.Todo;
import com.dgpad.thyme.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;


@Controller
public class ListController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/my_todoList")
    public String manageTodo(Model model) {
        model.addAttribute("newtodo", new Todo());
        model.addAttribute("todoList", todoService.getAll());

        return "manage-todo";
    }
    @PostMapping("/add-todo")
    public String addTodo(@ModelAttribute("newtodo") Todo newtodo) {

        todoService.save(newtodo);
        return "redirect:/my_todoList";
    }
    @PostMapping("/edit-todo")
    public String editTodo(@RequestParam("id") int id, @RequestParam("updatedTitle") String title, @RequestParam("updatedDescription") String description) {
        todoService.edit(id,title,description);
        return "redirect:/my_todoList";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodo(@PathVariable("id") int id) {
        todoService.delete(id);
        return "redirect:/my_todoList";
    }
    @GetMapping("/completed/{id}")
    public String completeTodo(@PathVariable("id") int id) {
        todoService.markcompleted(id);
        return "redirect:/my_todoList";
    }

}