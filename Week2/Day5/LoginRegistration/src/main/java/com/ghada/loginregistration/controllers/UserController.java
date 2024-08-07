package com.ghada.loginregistration.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ghada.loginregistration.models.LoginUser;
import com.ghada.loginregistration.models.User;
import com.ghada.loginregistration.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	// === Display Route === Login and register forms
	@GetMapping("/")
	public String index(Model model) {

		// Bind empty User and LoginUser objects to the JSP
		// to capture the form input
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "user/login.jsp";
	}

	// ==== Action Route ==== Registration
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model,
			HttpSession session) {

		// 1. Execute the Service method
		userService.register(newUser, result);
		
		//check the errors and rerender our page
		if (result.hasErrors()) {
			// Be sure to send in the empty LoginUser before
			// re-rendering the page.
			model.addAttribute("newLogin", new LoginUser());
			return "user/login.jsp";
		} else {
			//save the user ID in the session to use where ever we want
			session.setAttribute("userID", newUser.getId());
			return "redirect:/welcome";
		}
	}

	// ====Display Route==== Home page
	@GetMapping("/welcome")
	public String welcome(HttpSession session, Model model) {
		Long id = (Long) session.getAttribute("userID");
		if (id == null) {
			//if the user is not logged in we should redirect him to the landing page
			return "redirect:/";
		} else {
			//get the logged in user
			User loggedinUser = userService.findOne(id);
			model.addAttribute("user", loggedinUser);
			return "user/welcome.jsp";
		}
	}

	// === Action Route === Login ===
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model,
			HttpSession session) {

		User user = userService.login(newLogin, result);

		if (result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "user/login.jsp";
		} else {
			session.setAttribute("userID", user.getId());
			return "redirect:/welcome";
		}

	}
	
	@PostMapping("/logout")
	public String logout(HttpSession session) {
		
		session.removeAttribute("userID");
		return "redirect:/";
	}
}