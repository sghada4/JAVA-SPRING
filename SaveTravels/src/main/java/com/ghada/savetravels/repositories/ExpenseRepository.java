package com.ghada.savetravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ghada.savetravels.models.Expense;

public interface ExpenseRepository extends CrudRepository<Expense, Long> {
	
	List<Expense> findAll();

}
