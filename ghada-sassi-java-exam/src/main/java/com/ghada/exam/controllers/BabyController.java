package com.ghada.exam.controllers;

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

import com.ghada.exam.models.Baby;
import com.ghada.exam.models.User;
import com.ghada.exam.services.BabyService;
import com.ghada.exam.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class BabyController {

	@Autowired
	private BabyService babyService;

	@Autowired
	private UserService userService;

	@GetMapping("/home")
	public String home(Model model, HttpSession s) {
		Long userId = (Long) s.getAttribute("userID");
		if (userId == null) {
			// if the user is not logged in we should redirect him to the landing page
			return "redirect:/";
		} else {
			List<Baby> allBabys = babyService.allBabys();
			model.addAttribute("allBabys", allBabys);

			User currentUser = userService.findUser(userId);
			model.addAttribute("currentUser", currentUser);
			return "baby/home.jsp";
		}
	}

	@GetMapping("/names/new")
	public String create(@ModelAttribute("baby") Baby b, Model model, HttpSession s) {
		Long userId = (Long) s.getAttribute("userID");
		if (userId == null) {
			// if the user is not logged in we should redirect him to the landing page
			return "redirect:/";
		} else {
			User user = userService.findUser(userId);
			model.addAttribute("user", user);
			return "baby/create.jsp";
		}
	}

	// ==== ACTION ROUTE ==== REDIRECT
	@PostMapping("/babies")
	public String create(@Valid @ModelAttribute("baby") Baby baby, BindingResult result, Model model,
			RedirectAttributes flash) {
		babyService.createBaby(baby, result);
		if (result.hasErrors()) {

			return "baby/create.jsp";
		} else {
			babyService.createBaby(baby, result);
			flash.addFlashAttribute("success", "Awesome ! You just created a new Name 🎉");
			return "redirect:/home";
		}
	}

	// EDIT PAGE == DISPLAY ROUTE
	@GetMapping("/names/{id}/edit")
	public String update(@PathVariable("id") Long id, Model model, HttpSession s) {
		Long userId = (Long) s.getAttribute("userID");
		if (userId == null) {
			// if the user is not logged in we should redirect him to the landing page
			return "redirect:/";
		} else {
			Baby baby = babyService.findBaby(id);
			model.addAttribute("baby", baby);
			return "baby/edit.jsp";
		}
	}

	// === ACTION ROUTE ===
	@PutMapping("/babies/{id}")
	public String updateBaby(@Valid @ModelAttribute("baby") Baby baby, BindingResult result,
			@PathVariable("id") Long id) {
		if (result.hasErrors()) {
			return "baby/edit.jsp";
		} else {

			// find the original baby's author (the other way is in the edit page)
			Baby ogBaby = babyService.findBaby(id);
			baby.setPostedBy(ogBaby.getPostedBy());
			baby.setBabyname(ogBaby.getBabyname());

			babyService.updateBaby(baby);

			return "redirect:/home";
		}
	}

	// DELETE
	@DeleteMapping("/babies/{id}")
	public String destroy(@PathVariable("id") Long id) {
		babyService.deleteBaby(id);
		return "redirect:/home";
	}

	// SHOW ONE
	@GetMapping("/names/{id}")
	public String showOne(@PathVariable("id") Long id, Model model, HttpSession s) {
		Long userId = (Long) s.getAttribute("userID");
		if (userId == null) {
			// if the user is not logged in we should redirect him to the landing page
			return "redirect:/";
		} else {
			User currentUser = userService.findUser(userId);
			Baby thisBaby = babyService.findBaby(id);
			model.addAttribute("baby", thisBaby);
			model.addAttribute("currentUser", currentUser);
			return "baby/show.jsp";
		}
	}

	// Add Vote
	@GetMapping("/addToVoteList/{babyId}")
	public String addToList(@PathVariable("babyId") Long babyId, HttpSession session) {
		// grab loggedIn user from session
		Long userId = (Long) session.getAttribute("userID");
		if (userId == null) {
			// if the user is not logged in we should redirect him to the landing page
			return "redirect:/";
		} else {

			// find user from the DB using id
			User loggedUser = userService.findUser(userId);

			// grab the selected baby from the DB
			Baby thisBaby = babyService.findBaby(babyId);

			// make many to many connection
			thisBaby.getVotedUsers().add(loggedUser);

			// don't forget to save to DB
			babyService.updateBaby(thisBaby);

			return "redirect:/home";
		}
	}

	// REMOVE Vote
	@GetMapping("/removeFromVoteList/{babyId}")
	public String removeFromList(@PathVariable("babyId") Long babyId, HttpSession session) {

		// grab loggedIn user from session
		Long userId = (Long) session.getAttribute("userID");
		if (userId == null) {
			// if the user is not logged in we should redirect him to the landing page
			return "redirect:/";
		} else {

			// find user from the DB using id
			User loggedUser = userService.findUser(userId);

			// grab the selected baby from the DB
			Baby thisBaby = babyService.findBaby(babyId);

			// make many to many connection
			thisBaby.getVotedUsers().remove(loggedUser);

			// don't forget to save to DB
			babyService.updateBaby(thisBaby);

			return "redirect:/home";
		}
	}

	// check the current user babies list
//	@GetMapping("/list")
//	public String showList(HttpSession s, Model model) {
//		
//		Long userId= (Long) s.getAttribute("userID");
//		User currentUser = userService.findUser(userId);
//		List<Baby> babysVoted = currentUser.getUserBabies();
//		model.addAttribute("list", babysVoted);
//		
//		return"list.jsp";
//	}
}
