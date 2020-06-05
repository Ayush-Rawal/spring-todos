package com.rawal.Todos.Models;

// import java.time.LocalDate;

// import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
// import org.springframework.data.domain.Page;
// import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TodoRepository extends CrudRepository <Todo, String> {
	// public Page<Todo> findByDueOn(LocalDate dueOn, Pageable page);
	// public Page<Todo> findByCreatedOn(LocalDate createdOn, Pageable page);
}