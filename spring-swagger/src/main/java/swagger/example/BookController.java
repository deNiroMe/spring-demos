package swagger.example;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {

    private final List<Book> books;

    public BookController() {
        books = new ArrayList<>();
        books.add(new Book("الحيوان", "الجاحظ",1057));
        books.add(new Book("Brave New World", " Aldous Huxley",288));
        books.add(new Book("Crime and Punishment", "Fyodor Dostoyevsky",671));
    }

    @GetMapping("/books")
    public List<Book> getBooks() {
        return books;
    }

    @PostMapping(value = "/books")
    public List<Book> addBook(@RequestBody Book book) {
        books.add(book);
        return books;
    }

    @DeleteMapping("/books")
    public String deleteBook(final Book book) {
        books.remove(book);
        return "redirect:/books";
    }

}
