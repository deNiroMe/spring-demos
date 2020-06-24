package ma.example.books.bookservice.ut.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import ma.example.books.controllers.BookController;
import ma.example.books.entities.Book;
import ma.example.books.services.BookService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

public class BookControllerTest {

    @Mock
    private BookService bookService;

    private BookController controller;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        controller = new BookController(bookService);
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .build();
    }

    @Test
    public void testGetBooksById() throws Exception {

        Book book = new Book();
        book.setBookId(1L);
        book.setTitle("Brave new world");
        book.setPages(500);

        when(bookService.getBook(any())).thenReturn(book);

        mockMvc.perform(get("/api/v1/books/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", Matchers.equalTo("Brave new world")))
                .andExpect(jsonPath("$.pages", Matchers.equalTo(500)));
    }

    @Test
    public void testGetBooks() throws Exception {

        List<Book> books = Arrays.asList(new Book(), new Book());

        when(bookService.getBooks()).thenReturn(books);

        mockMvc.perform(get("/api/v1/books"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", Matchers.hasSize(2)));
    }

    @Test
    public void testCreateBook() throws Exception {

        Book book = new Book();
        book.setTitle("Brave new world");
        book.setPages(500);

        ObjectMapper mapper = new ObjectMapper();

        when(bookService.createBook(any())).thenReturn(book);

        mockMvc.perform(post("/api/v1/books")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(mapper.writeValueAsString(book))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Brave new world"))
                .andExpect(jsonPath("$.pages").value("500"));
    }

    @Test
    public void testDeleteBook() throws Exception {

        mockMvc.perform(delete("/api/v1/books/1")
                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk());

        verify(bookService).deleteBook(anyLong());
    }

}
