package com.ghada.omikuji.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	
	@RequestMapping("/omikuji")
	public String form() {
		return "form.jsp";
	}
	
	//Action Route 
	@RequestMapping(value="/processForm", method=RequestMethod.POST)
	public String processForm(@RequestParam(value="number") Integer number,
			@RequestParam(value="city") String city,
			@RequestParam(value="person") String person,
			@RequestParam(value="hobby") String hobby,
			@RequestParam(value="livingThing") String livingThing,
			@RequestParam(value="message") String message, HttpSession session) {
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("hobby", hobby);
		session.setAttribute("livingThing", livingThing);
		session.setAttribute("message", message);
		return "redirect:/omikuji/show";
	}

	//Display Route 
		@RequestMapping("/omikuji/show")
		public String showOmikuji() {
			return "show.jsp";
		}

}
