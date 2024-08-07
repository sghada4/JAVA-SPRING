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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ghada.dojoninjas.models.Dojo;
import com.ghada.dojoninjas.models.Ninja;
import com.ghada.dojoninjas.services.DojoService;
import com.ghada.dojoninjas.services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class NinjaController {

	@Autowired
	private NinjaService ninjaService;
	@Autowired
	private DojoService dojoService;

	@GetMapping("/ninjas")
	public String index(Model model) {
		List <Ninja> allNinjas = ninjaService.allNinjas();
		model.addAttribute("allNinjas",allNinjas);
		return "ninja/ninjas.jsp";
	}
	
	// ==== DISPLAY ROUTE ====

	
	@GetMapping("/ninjas/create")
	public String create(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> allDojos = dojoService.allDojos();
		model.addAttribute("allDojos", allDojos);
		return "ninja/create.jsp";
	}
	// ==== ACTION ROUTE ==== REDIRECT
	@PostMapping("/ninjas/new")
    public String create(@Valid @ModelAttribute("ninja") Ninja ninja,
    					BindingResult result,
    					Model model,
    					RedirectAttributes flash) {
        if (result.hasErrors()) {
        	List<Dojo> allDojos = dojoService.allDojos();
    		model.addAttribute("allDojos", allDojos);
            return "ninja/create.jsp";
        } else {
            ninjaService.createNinja(ninja);
            flash.addFlashAttribute("success","Awesome ! You just created a Ninja 🎉");
            return "redirect:/ninjas";
        }
    }
	
	// EDIT PAGE == DISPLAY ROUTE
	@GetMapping("/ninjas/edit/{id}")
	public String update(@PathVariable("id") Long id, Model model) {
		Ninja ninja = ninjaService.findNinja(id);
		model.addAttribute("ninja",ninja);
		return "ninja/edit.jsp";
	}
	
	// === ACTION ROUTE ===
	@PutMapping("/ninjas/{id}")
	public String updateNinja(@Valid @ModelAttribute("ninja") Ninja ninja,
							BindingResult result) {
		if(result.hasErrors()) {
			return "ninja/edit.jsp";
		} else {
			ninjaService.updateNinja(ninja);
			return "redirect:/ninjas";
		}
	}
	
	// DELETE
	@DeleteMapping("/ninjas/{id}")
	public String destroy(@PathVariable("id") Long id) {
		ninjaService.deleteNinja(id);
		return "redirect:/ninjas";
	}
	
	// SHOW ONE
	@GetMapping("/ninjas/{id}")
	public String showOne(@PathVariable("id") Long id, Model model) {
		Ninja thisNinja = ninjaService.findNinja(id);
		model.addAttribute("ninja", thisNinja);
		return "ninja/show.jsp";
	}
	

}
