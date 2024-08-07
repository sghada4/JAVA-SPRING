package com.ghada.savetravels.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.ghada.savetravels.models.Expense;
import com.ghada.savetravels.services.ExpenseService;

import jakarta.validation.Valid;

@Controller
public class ExpenseController {

	@Autowired
	private ExpenseService expenseService;

	@GetMapping("/")
	public String index(Model model) {
		List<Expense> allExpenses = expenseService.allExpenses();
		model.addAttribute("allExpenses", allExpenses);
		Expense e = new Expense();
		model.addAttribute("expense", e);
		return "index.jsp";
	}

	// ==== DISPLAY ROUTE ====

//	@GetMapping("/create")
//	public String create(@ModelAttribute("burger") Burger b) {
//		return "create.jsp";
//	}
	// ==== ACTION ROUTE ==== REDIRECT
	@PostMapping("/expenses")
	public String create(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
		if (result.hasErrors()) {
			return "index.jsp";
		} else {
			expenseService.createExpense(expense);
			return "redirect:/";
		}
	}

	// EDIT PAGE == DISPLAY ROUTE
	@GetMapping("/expenses/edit/{id}")
	public String update(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseService.findExpense(id);
		model.addAttribute("expense", expense);
		return "edit.jsp";
	}

	// === ACTION ROUTE ===
	@PutMapping("/expenses/{id}")
	public String updateExpense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			expenseService.updateExpense(expense);
			return "redirect:/";
		}
	}
	
	// DELETE
		@DeleteMapping("/expenses/{id}")
		public String destroy(@PathVariable("id") Long id) {
			expenseService.deleteExpense(id);
			return "redirect:/";
		}
		
		// SHOW ONE
		@GetMapping("/expenses/{id}")
		public String showOne(@PathVariable("id") Long id, Model model) {
			Expense thisExpense = expenseService.findExpense(id);
			model.addAttribute("expense", thisExpense);
			return "show.jsp";
		}
}