package ru.intervale.courses.bookstore.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.intervale.courses.bookstore.entities.Book;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class BookService {

    Map<Long, String> storage = new HashMap<>();

    ObjectMapper objectMapper;

    public String addBook(Long id, String src) throws JsonProcessingException {
        return storage.put(id, new ObjectMapper().readerFor(Book.class).readValue(src));
    }

    public String getBook(Long id) {
        return storage.get(id);
    }

    public String getAllBook() {
        return "\n" + storage.toString() + "\n";
    }

    public String editBook(Long id, String src) throws JsonProcessingException {
        return storage.replace(id, new ObjectMapper().readerFor(Book.class).readValue(src));
    }

    public String deleteBook(Long id) {
        return storage.remove(id);
    }


}
