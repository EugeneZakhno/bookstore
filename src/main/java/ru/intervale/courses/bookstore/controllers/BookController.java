package ru.intervale.courses.bookstore.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.intervale.courses.bookstore.entities.Book;
import ru.intervale.courses.bookstore.service.BookService;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping(value = "/add")
    public int addBook(@Valid @RequestBody Book book) {
    return bookService.save(book);
   }

    @GetMapping(value = "/get")
    public List<Book> getAllBooks() { return bookService.findAll(); }

    @PostMapping(value = "/edit/{id}")
    public int editBook(@PathVariable Long id, @Valid @RequestBody Book book) {
        return bookService.edit(id, book);
    }

    @PostMapping(value = "/delete/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.delete(id);
    }

}
