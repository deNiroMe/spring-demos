package ma.example.books.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.example.books.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> { }
