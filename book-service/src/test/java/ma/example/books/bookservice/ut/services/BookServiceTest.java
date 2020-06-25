package ma.example.books.bookservice.ut.services;

import ma.example.books.entities.Book;
import ma.example.books.repositories.BookRepository;
import ma.example.books.services.BookService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class BookServiceTest {

    public static final String TITLE = "Brave new world";
    public static final int PAGES = 500;

    private BookService service;

    @Mock
    private BookRepository bookRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        service = new BookService(bookRepository);
    }

    @Test
    public void testGetBooksById() throws Exception {

        Book book = new Book();
        book.setBookId(1L);
        book.setTitle(TITLE);
        book.setPages(PAGES);

        Optional<Book> optionalBook = Optional.of(book);
        when(bookRepository.findById(any())).thenReturn(optionalBook);
        Book book1 = service.getBook(any());

        assertEquals(book1.getTitle(), TITLE);
        verify(bookRepository , times(1)).findById(any());
    }

    @Test
    public void testGetBooks() throws Exception {

        List<Book> books = Arrays.asList(new Book(), new Book());

        when(bookRepository.findAll()).thenReturn(books);

        final List<Book> books1 = service.getBooks();
        assertEquals(books1.size(), 2);
        verify(bookRepository, times(1)).findAll();
    }

    @Test
    public void testCreateBook() throws Exception {

        Book book = new Book();
        book.setTitle(TITLE);
        book.setPages(PAGES);

        when(bookRepository.save(any())).thenReturn(book);

        final Book book1 = service.createBook(book);
        assertEquals(book1.getTitle(), TITLE);
        assertEquals(book1.getPages(), PAGES);

        verify(bookRepository , times(1)).save(any());
    }

}
