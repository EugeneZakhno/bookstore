package ru.intervale.courses.bookstore.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.intervale.courses.bookstore.entities.Book;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class BookService {

    HashMap <Long, Book> storage;

    public Book addBook(Long id,Book book) {
        return storage.put(id, book);
    }

    public Book getBook(Long id) {
        return storage.get(id);
    }

    public String getAllBook() {
       for (Map.Entry<Long, Book> entry : storage.entrySet()) {
           return  "id= " + entry.getKey() + ", Книга: " + entry.getValue();
       }
        return ";\n";
    }

    public Book editBook(Long id,Book book) {
        return storage.replace(id, book);
    }

    public Book deleteBook(Long id) {
        return storage.remove(id);
    }


}
