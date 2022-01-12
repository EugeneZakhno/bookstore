package ru.intervale.courses.bookstore.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.intervale.courses.bookstore.entities.Book;
import ru.intervale.courses.bookstore.service.BookService;

@RestController
@AllArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping(value = "/add/{id}")
    @ResponseBody
    public Book addBook(@PathVariable Long id, @RequestBody Book book) {
    return bookService.addBook(id, book);
   }

    @GetMapping(value = "/get")
    @ResponseBody
    public String getAllBook() {
       return bookService.getAllBook();
    }

    @GetMapping(value = "/get/{id}")
    @ResponseBody
    public Book getBook(@PathVariable Long id) {
        return bookService.getBook(id);
    }

    @PostMapping(value = "/edit/{id}")
    @ResponseBody
    public Book editBook(@PathVariable Long id, @RequestBody Book book) {
        return bookService.editBook(id, book);
    }

    @PostMapping(value = "/delete/{id}")
    @ResponseBody
    public Book deleteBook(@PathVariable Long id) {
        return bookService.deleteBook(id);
    }

}
