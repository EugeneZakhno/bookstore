package ru.intervale.courses.bookstore.repositories;

import org.springframework.stereotype.Repository;
import ru.intervale.courses.bookstore.entities.Book;

import java.util.HashMap;
import java.util.Map;

@Repository
public interface BookRepository {

    Map<Long, Book> storage = new HashMap<Long, Book>(Map.of(1L, Book.builder()
            .id(1L)
            .author("dfgg")
            .ISBN("dfhh")
            .build()));

}
