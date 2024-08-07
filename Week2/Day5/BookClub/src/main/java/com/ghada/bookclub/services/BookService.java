package com.ghada.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ghada.bookclub.models.Book;
import com.ghada.bookclub.repositories.BookRepository;

@Service
public class BookService {
    
	// adding the book repository as a dependency using @Autowired
	@Autowired
	private BookRepository bookRepository;
	
	 // READ ALL
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // CREATE
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // find one book by id
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        return optionalBook.isPresent() ? optionalBook.get() : null ;	
    }
    
    // Update a Book
    public Book	updateBook(Book book) {
    	return bookRepository.save(book);
    }
    
    // DELETE a Book
    public void deleteBook(Long id) {
    	bookRepository.deleteById(id);
    }
}
