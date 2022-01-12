package ru.intervale.courses.bookstore.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.intervale.courses.bookstore.entities.Book;
import ru.intervale.courses.bookstore.service.BookService;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@ControllerAdvice
@AllArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping(value = "/add/{id}")
    public Book addBook(@PathVariable @Min(1) Long id, @Valid @RequestBody Book book) {
    return bookService.addBook(id, book);
   }

    @GetMapping(value = "/get")
    public String getAllBook() {
       return bookService.getAllBook();
    }

    @GetMapping(value = "/get/{id}")
    public Book getBook(@PathVariable Long id) {
        return bookService.getBook(id);
    }

    @PostMapping(value = "/edit/{id}")
    public Book editBook(@PathVariable @Min(1) Long id, @Valid @RequestBody Book book) {
        return bookService.editBook(id, book);
    }

    @PostMapping(value = "/delete/{id}")
    public Book deleteBook(@PathVariable Long id) {
        return bookService.deleteBook(id);
    }



}
