package com.ghada.dojoninjas.controllers;

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

import com.ghada.dojoninjas.models.Dojo;
import com.ghada.dojoninjas.services.DojoService;

import jakarta.validation.Valid;

@Controller
public class DojoController {

	@Autowired
	private DojoService dojoService;

	//Home ===Display route ===
	@GetMapping("/")
	public String home() {
		return "home.jsp";
	}

	//Dashboard ===Display route ===
	@GetMapping("/dojos")
	public String dojos(Model model) {
		List<Dojo> allDojos = dojoService.allDojos();
		model.addAttribute("allDojos", allDojos);
		return "dojo/dojos.jsp";
	}

	// Create a Dojo === Display ROUTE ===
	@GetMapping("/dojos/new")
	public String create(@ModelAttribute("dojo") Dojo dojo) {
		return "dojo/create.jsp";
	}

	// Create a Dojo === ACTION ROUTE ==== REDIRECT
	@PostMapping("/dojos/create")
	public String create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			
			return "dojo/create.jsp";
		} else {
			dojoService.createDojo(dojo);
			return "redirect:/dojos";
		}
	}
	
	// DELETE
	@DeleteMapping("/dojos/{id}")
	public String destroy(@PathVariable("id") Long id) {
		dojoService.deleteDojo(id);
		return "redirect:/dojos";
	}

	// SHOW ONE
	@GetMapping("/dojos/{id}")
	public String showOne(@PathVariable("id") Long id, Model model) {
		Dojo thisDojo = dojoService.findDojo(id);
		model.addAttribute("dojo", thisDojo);
		
		return "dojo/show.jsp";
	}
}
