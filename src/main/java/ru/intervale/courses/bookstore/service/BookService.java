package ru.intervale.courses.bookstore.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.intervale.courses.bookstore.entities.Book;
import ru.intervale.courses.bookstore.repositories.BookRepository;

@Service
@AllArgsConstructor
public class BookService {


    private final BookRepository bookRepository;
    public Book addBook(Book book) {

        return bookRepository.storage.put(book.getId(), book);
    }





}
