package ma.example.books.controllers;

import java.util.List;

import lombok.AllArgsConstructor;
import ma.example.books.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ma.example.books.entities.Book;
import ma.example.books.repositories.BookRepository;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class BookController {

	private final BookService bookService;

	@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {
		return bookService.createBook(book);
	}

	@GetMapping("/books/{bookId}")
	public Book getBookById(@PathVariable final Long bookId) {
		return bookService.getBook(bookId);
	}

	@GetMapping("/books")
	public List<Book> getBooks() {
		return bookService.getBooks();
	}

	@DeleteMapping("/books/{bookId}")
	public ResponseEntity<Void> deleteBook(@PathVariable final Long bookId) {
		 bookService.deleteBook(bookId);
		 return new ResponseEntity<>(HttpStatus.OK);
	}
}
