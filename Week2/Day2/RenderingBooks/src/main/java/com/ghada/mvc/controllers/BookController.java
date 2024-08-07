package com.ghada.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.ghada.mvc.models.Book;

@Controller
public class BookController {

	@RequestMapping("/books/{id}")
	public String showBook(@PathVariable("id") Long id, Model model) {
		String uri = "http://localhost:8080/api/books/" + id;
		RestTemplate restTemplate = new RestTemplate();

		Book book = restTemplate.getForObject(uri, Book.class);
		model.addAttribute("book", book);
		return "show.jsp";
	}

}
