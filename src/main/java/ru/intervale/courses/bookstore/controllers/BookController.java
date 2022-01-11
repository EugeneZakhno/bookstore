package ru.intervale.courses.bookstore.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.intervale.courses.bookstore.entities.Book;
import ru.intervale.courses.bookstore.service.BookService;

@RestController
@AllArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping(value = "/add")
   public Book addBook(@RequestBody Book book) {
    return bookService.addBook(book);
   }






}
