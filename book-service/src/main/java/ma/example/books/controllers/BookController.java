package ma.example.books.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ma.example.books.entities.Book;
import ma.example.books.repositories.BookRepository;

@RestController
public class BookController {

	private final BookRepository bookRepository;

	public BookController(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}
	
	@GetMapping("/books")
	public List<Book> getBooks() {
		return bookRepository.findAll();
	}
	
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {
		return bookRepository.save(book);
	}
}
