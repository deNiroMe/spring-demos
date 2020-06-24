package ma.example.books.services;

import lombok.AllArgsConstructor;
import ma.example.books.entities.Book;
import ma.example.books.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public Book getBook(Long bookId) {
        return bookRepository.findById(bookId).orElseThrow(RuntimeException::new);
    }

    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }

}
