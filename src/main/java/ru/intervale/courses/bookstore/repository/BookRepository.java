package ru.intervale.courses.bookstore.repository;


import org.springframework.stereotype.Repository;
import ru.intervale.courses.bookstore.entities.Book;

import java.util.List;

@Repository
public interface BookRepository {

    List<Book> findAll();

    void edit(Long id, Book book);

    void save(Book book);

    void delete(Long id);
}
