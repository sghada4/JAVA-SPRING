package com.ghada.exam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ghada.exam.models.LoginUser;
import com.ghada.exam.models.User;
import com.ghada.exam.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {

	// Dependency injection
	@Autowired
	private UserService userService;

	// Landing Page (login and register) === Display Route ===
	@GetMapping("/")
	public String index(Model model) {
		// Bind empty User and LoginUser objects to the JSP
		// to capture the form input
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "user/log_reg.jsp";
	}

	// ==== Action Route for registration====
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model,
			HttpSession session) {

		// 1. Execute the Service method
		userService.register(newUser, result);

		// check the errors and rerender our page
		if (result.hasErrors()) {
			// Be sure to send in the empty LoginUser before
			// re-rendering the page.
			model.addAttribute("newLogin", new LoginUser());
			return "user/log_reg.jsp";
		} else {
			// save the user ID in the session to use where ever we want
			session.setAttribute("userID", newUser.getId());
			return "redirect:/home";
		}

	}

	// ======Action route to login======
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model,
			HttpSession session) {

		// 1. Execute the Service login method
		User user = userService.login(newLogin, result);

		if (result.hasErrors()) {
			// Be sure to send in the empty newUser before
			// re-rendering the page.
			model.addAttribute("newUser", new User());
			return "user/log_reg.jsp";
		} else {
			// No errors! Store their ID from the DB in session, and log in
			session.setAttribute("userID", user.getId());
			return "redirect:/home";
		}

	}

	// ======Action route to logout======
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}
