package ru.intervale.courses.bookstore.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.intervale.courses.bookstore.entities.Book;
import ru.intervale.courses.bookstore.service.BookService;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@AllArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping(value = "/add")
    public Book addBook(@Valid @RequestBody Book book) {
    return bookService.addBook(book);
   }

    @GetMapping(value = "/get")
    public List<Book> getAllBook() {
       return bookService.getAllBook();
    }


    @PostMapping(value = "/edit")
    public Book editBook(@Valid @RequestBody Book book) {
        return bookService.editBook(book);
    }

    @PostMapping(value = "/delete/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

}
