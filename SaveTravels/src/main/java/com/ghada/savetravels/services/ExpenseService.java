package com.ghada.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ghada.savetravels.models.Expense;
import com.ghada.savetravels.repositories.ExpenseRepository;


@Service
public class ExpenseService {

	@Autowired
	private ExpenseRepository expenseRepository;

	// READ ALL
	public List<Expense> allExpenses() {
		return expenseRepository.findAll();
	}

	// CREATE
	public Expense createExpense(Expense e) {
		return expenseRepository.save(e);
	}

	// retrieves a Expense
	public Expense findExpense(Long id) {
		Optional<Expense> optionalExpense = expenseRepository.findById(id);

		return optionalExpense.isPresent() ? optionalExpense.get() : null;

	}

	// Update a Expense
	public Expense updateExpense(Expense e) {
		return expenseRepository.save(e);
	}
	
	// DELETE a Expense
    public void deleteExpense(Long id) {
    	expenseRepository.deleteById(id);
    }

}
