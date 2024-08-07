package com.ghada.bookclub.controllers;

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

import com.ghada.bookclub.models.Book;
import com.ghada.bookclub.models.User;
import com.ghada.bookclub.services.BookService;
import com.ghada.bookclub.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;

	@Autowired
	private UserService userService;

	@GetMapping("/books")
	public String index(Model model, HttpSession session) {

		Long id = (Long) session.getAttribute("userID");
		if (id == null) {
			// if the user is not logged in we should redirect him to the landing page
			return "redirect:/";
		} else {
			// get the logged in user
			User loggedinUser = userService.findOne(id);
			model.addAttribute("user", loggedinUser);
			List<Book> allBooks = bookService.allBooks();
			model.addAttribute("allBooks", allBooks);
			return "book/index.jsp";
		}
	}

	// ==== DISPLAY ROUTE ====
	@GetMapping("/books/new")
	public String create(@ModelAttribute("book") Book b, Model model, HttpSession session) {
		Long id = (Long) session.getAttribute("userID");
		if (id == null) {
			// if the user is not logged in we should redirect him to the landing page
			return "redirect:/";
		} else {
			// get the logged in user
			User loggedinUser = userService.findOne(id);
			model.addAttribute("user", loggedinUser);
			return "book/create.jsp";
		}

	}

	// ==== ACTION ROUTE ==== REDIRECT
	@PostMapping("/books")
	public String create(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model,
			RedirectAttributes flash) {
		if (result.hasErrors()) {

			return "book/create.jsp";
		} else {
			bookService.createBook(book);
			flash.addFlashAttribute("success", "Awesome ! You just created a Book 🎉");
			return "redirect:/books";
		}
	}

	// EDIT PAGE == DISPLAY ROUTE
	@GetMapping("/books/{id}/edit")
	public String update(@PathVariable("id") Long id, Model model, HttpSession session) {

		Long userId = (Long) session.getAttribute("userID");
		if (userId == null) {
			// if the user is not logged in we should redirect him to the landing page
			return "redirect:/";
		} else {

			Book book = bookService.findBook(id);
			model.addAttribute("book", book);
			return "book/edit.jsp";
		}
	}

	// === ACTION ROUTE ===
	@PutMapping("/books/{id}")
	public String updateBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if (result.hasErrors()) {
			return "book/edit.jsp";
		} else {
			bookService.updateBook(book);
			return "redirect:/books";
		}
	}

	// DELETE
	@DeleteMapping("/books/{id}")
	public String destroy(@PathVariable("id") Long id) {
		bookService.deleteBook(id);
		return "redirect:/books";
	}

	// SHOW ONE
	@GetMapping("/books/{id}")
	public String showOne(@PathVariable("id") Long id, Model model, HttpSession session) {

		Long userId = (Long) session.getAttribute("userID");
		if (userId == null) {
			// if the user is not logged in we should redirect him to the landing page
			return "redirect:/";
		} else {
			// get the logged in user
			User loggedinUser = userService.findOne(userId);
			model.addAttribute("user", loggedinUser);
			Book thisBook = bookService.findBook(id);
			model.addAttribute("book", thisBook);
			return "book/show.jsp";
		}
	}

}