package com.todos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todos.models.Todo;

public interface TodosRepository extends JpaRepository<Todo, Integer> {

}
