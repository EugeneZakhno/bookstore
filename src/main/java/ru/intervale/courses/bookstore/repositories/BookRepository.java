package ru.intervale.courses.bookstore.repositories;


import org.springframework.stereotype.Repository;
import ru.intervale.courses.bookstore.entities.Book;

import java.util.HashMap;
import java.util.Map;

@Repository
public class BookRepository {

 private final Map<Long, Book> storage = new HashMap<>();

}
