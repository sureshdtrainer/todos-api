package com.todos.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.todos.exceptions.ResourceNotFoundException;
import com.todos.models.Todo;
import com.todos.services.TodosService;

@Service
public class TodosServiceInMemoryDatabaseImpl implements TodosService {
	
	private static List<Todo> todos = new ArrayList<>();
	private static int todosCount =3;
	
	static {
		todos.add(new Todo(1,"Jack", "Learn Spring Boot", new Date(), false));
		todos.add(new Todo(2,"Jill", "Learn Spring JPA", new Date(), false));
		todos.add(new Todo(3,"Bob", "Learn Angular", new Date(), false));
	}

	@Override
	public List<Todo> getAllTodos() {
		return todos;
	}

	@Override
	public Todo getTodoById(int id) throws ResourceNotFoundException {
		for (Todo todo: todos) {
			if (todo.getId() == id) {
				return todo;
			}
		}
		throw new ResourceNotFoundException("todos", "id", id);
	}

	@Override
	public List<Todo> getTodosByUser(String user) {
		List<Todo> userTodos = new ArrayList<>();
		for (Todo todo: todos) {
			if (todo.getUser().equals(user)) {
				userTodos.add(todo);
			}
		}
		return userTodos;
	}

	@Override
	public Todo saveTodo(Todo todo) {
		todo.setId(++todosCount);
		todos.add(todo);
		return todo;
	}

}
