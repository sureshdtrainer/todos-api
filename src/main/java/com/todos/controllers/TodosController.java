package com.todos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.todos.models.Todo;
import com.todos.services.TodosService;

@RestController
public class TodosController {
	
	@Autowired
	private TodosService todosService;
	
	@GetMapping("todos")
	public List<Todo> getAllTodos() {
		return todosService.getAllTodos();
	}
	
	@GetMapping("todos/user/{name}")
	public List<Todo> getTodosByUser(@PathVariable String name){
		return todosService.getTodosByUser(name);
	}
	
	@GetMapping("todos/{id}")	
	public Todo getTodoById(@PathVariable int id) {
		return todosService.getTodoById(id);
	}
	
	@PostMapping("/todos")
	public ResponseEntity<Todo> saveTodo(@RequestBody Todo todo) {
		Todo newTodo = todosService.saveTodo(todo);
		return new ResponseEntity<Todo>(newTodo,HttpStatus.CREATED);
	}
	
	
	
	

}
