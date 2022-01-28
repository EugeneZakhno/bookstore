package ru.intervale.courses.bookstore.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.intervale.courses.bookstore.entities.Book;
import ru.intervale.courses.bookstore.service.BookService;

import javax.validation.Valid;
import java.io.DataInput;
import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping(value = "/add")
    public void addBook(@Valid @RequestBody Book book) {
       bookService.save(book);
   }

    @GetMapping(value = "/get")
    public List<Book> getAllBooks() { return bookService.findAll(); }

    @PostMapping(value = "/edit/{id}")
    public  void editBook(@PathVariable Long id, @Valid @RequestBody Book book) {
        bookService.edit(id, book);
    }

    @PostMapping(value = "/delete/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.delete(id);
    }

}
