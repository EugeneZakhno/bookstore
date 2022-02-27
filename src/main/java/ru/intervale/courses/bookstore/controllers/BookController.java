package ru.intervale.courses.bookstore.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import ru.intervale.courses.bookstore.entities.Book;
import ru.intervale.courses.bookstore.service.BookService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Component
@RestController
@AllArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping(value = "/get")
    public List<Book> getAllBookRecords()
    { return bookService.findAllBooks(); }

    @GetMapping(value = "{bookId}")
    public Optional<Book> getBookById(@PathVariable(value = "bookId") Long bookId) {
        return bookService.findById(bookId);
    }

    @PostMapping(value = "/add")
    public Book createBookRecord(@RequestBody @Valid Book bookRecord) {
        return bookService.save(bookRecord);
    }

    @PostMapping(value = "/edit")
    public  Book editBook(@Valid @RequestBody Book book) {
       return bookService.edit(book);
    }

    @PostMapping(value = "/delete/{id}")
    public void deleteBook(@PathVariable Long id) {
      bookService.delete(id);
    }

}
