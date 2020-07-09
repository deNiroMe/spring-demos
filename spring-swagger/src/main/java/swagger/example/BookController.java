package swagger.example;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Tag(name = "Books Service", description = "A simple books api to test swagger functionality")
public class BookController {

    private final List<Book> books;

    public BookController() {
        books = new ArrayList<>();
        books.add(new Book("الحيوان", "الجاحظ",1057));
        books.add(new Book("Brave New World", " Aldous Huxley",288));
        books.add(new Book("Crime and Punishment", "Fyodor Dostoyevsky",671));
    }

    @GetMapping("/books")
    @Operation(
            summary = "get all books",
            description = "get list of available books" )
    public List<Book> getBooks() {
        return books;
    }

    @PostMapping(value = "/books")
    @Operation(
            summary = "add new book",
            description = "add new book to available books books" )
    public List<Book> addBook(@RequestBody final Book book) {
        books.add(book);
        return books;
    }

    @DeleteMapping("/books")
    @Operation(
            summary = "delete book",
            description = "remove book from list of available books" )
    public List<Book> deleteBook(@RequestBody final Book book) {
        books.remove(book);
        return books;
    }

}
