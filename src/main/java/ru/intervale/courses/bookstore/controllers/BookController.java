package ru.intervale.courses.bookstore.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.intervale.courses.bookstore.entities.Book;
import ru.intervale.courses.bookstore.service.BookService;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@AllArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping(value = "/add/{id}")
    public String addBook(@PathVariable @Min(1) Long id, @Valid @RequestBody String str) throws JsonProcessingException {
    return bookService.addBook(id, str);
   }

    @GetMapping(value = "/get")
    public String getAllBook() {
       return bookService.getAllBook();
    }

    @GetMapping(value = "/get/{id}")
    public String getBook(@PathVariable Long id) {
        return bookService.getBook(id);
    }

    @PostMapping(value = "/edit/{id}")
    public String editBook(@PathVariable @Min(1) Long id, @Valid @RequestBody String str) throws JsonProcessingException {
        return bookService.editBook(id, str);
    }

    @PostMapping(value = "/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        return bookService.deleteBook(id);
    }

}
