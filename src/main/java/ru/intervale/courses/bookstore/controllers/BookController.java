package ru.intervale.courses.bookstore.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import ru.intervale.courses.bookstore.entities.Book;
import ru.intervale.courses.bookstore.service.BookService;

import javax.validation.Valid;
import java.io.IOException;
import java.net.http.HttpResponse;
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

    @GetMapping(value = "/get/{id}")
    public Book getBookById(@PathVariable(value = "id") Long id) {
        return bookService.getBook(id);
    }

    @GetMapping(value = "/find_openlibrary/{authorName}")
    public String getBookByAuthorOpenlibrary(@PathVariable(value = "authorName") String author) throws IOException, InterruptedException {
        getBookByAuthor(author);
        return bookService.findByAuthorOpenLibrary(author);
    }

    @GetMapping(value = "/find/{authorName}")
    public List<Book> getBookByAuthor(@PathVariable(value = "authorName") String author) {
    return bookService.findByAuthor(author);
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
