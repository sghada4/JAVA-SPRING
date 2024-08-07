package com.ghada.burgertracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.ghada.burgertracker.models.Burger;
import com.ghada.burgertracker.services.BurgerService;

import jakarta.validation.Valid;

@Controller
public class BurgerController {

	@Autowired
	private BurgerService burgerService;

	@GetMapping("/")
	public String index(Model model) {
		List<Burger> allBurgers = burgerService.allBurgers();
		model.addAttribute("allBurgers", allBurgers);
		Burger b = new Burger();
		model.addAttribute("burger", b);
		return "index.jsp";
	}

	// ==== DISPLAY ROUTE ====

//	@GetMapping("/create")
//	public String create(@ModelAttribute("burger") Burger b) {
//		return "create.jsp";
//	}
	// ==== ACTION ROUTE ==== REDIRECT
	@PostMapping("/burgers")
	public String create(@Valid @ModelAttribute("burger") Burger burger, BindingResult result) {
		if (result.hasErrors()) {
			return "index.jsp";
		} else {
			burgerService.createBurger(burger);
			return "redirect:/";
		}
	}

	// EDIT PAGE == DISPLAY ROUTE
	@GetMapping("/burgers/edit/{id}")
	public String update(@PathVariable("id") Long id, Model model) {
		Burger burger = burgerService.findBurger(id);
		model.addAttribute("burger", burger);
		return "edit.jsp";
	}

	// === ACTION ROUTE ===
	@PutMapping("/burgers/{id}")
	public String updateBurger(@Valid @ModelAttribute("burger") Burger burger, BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			burgerService.updateBurger(burger);
			return "redirect:/";
		}
	}
}
