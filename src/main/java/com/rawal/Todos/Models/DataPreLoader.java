package com.rawal.Todos.Models;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.extern.java.Log;

@Log
@Component
public class DataPreLoader implements CommandLineRunner {

	@Autowired
	private TodoRepository repository;

	public DataPreLoader(TodoRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run(String... strings) throws Exception {
		log.info("Running");
		this.repository.save(new Todo(
			"Todo Taske 1", "Description", LocalDate.now(), LocalDate.now().plusDays(1), "Ayush", false
			));
		this.repository.save(new Todo(
			"Todo Taske 1", "Description", LocalDate.now(), LocalDate.now().plusDays(1), "Ayush", false
			));
		this.repository.save(new Todo(
			"Todo Taske 1", "Description", LocalDate.now(), LocalDate.now().plusDays(1), "Ayush", false
			));
		this.repository.save(new Todo(
			"ToDo: To Do?", "Do Do", LocalDate.now(), LocalDate.now().plusDays(1), "Task Master", false
			));
			
	}

}