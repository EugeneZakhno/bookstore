package ru.intervale.courses.bookstore.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.intervale.courses.bookstore.entities.Book;

import java.util.Map;

@Service
@AllArgsConstructor
public class BookService {

    Map <Long, Book> storage;

    ObjectMapper objectMapper = new ObjectMapper();

    public Book addBook(Long id, Book book) {
        return storage.put(id, book);
    }

    public Book getBook(Long id) {
        return storage.get(id);
    }

    public String getAllBook() {
        return "\n" + storage.toString() + "\n";
    }

    public Book editBook(Long id, Book book) {
        return storage.replace(id, book);
    }

    public Book deleteBook(Long id) {
        return storage.remove(id);
    }


}
