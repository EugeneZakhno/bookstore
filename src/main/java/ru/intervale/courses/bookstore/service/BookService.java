
package ru.intervale.courses.bookstore.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import ru.intervale.courses.bookstore.entities.Book;
import ru.intervale.courses.bookstore.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class BookService {

    BookRepository bookRepository;

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBook(Long id) {
        Optional<Book> bookResponse = bookRepository.findById(id);
        Book book = bookResponse.get();
        return book;
    }

    public String findByAuthorOpenLibrary(String author) {
        WebClient webClient = WebClient.create("https://openlibrary.org");
        return webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/authors/" + author + ".json")
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .block()
                + "\n" + findByAuthor(author);
    }

    public List<Book> findByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    public Book edit(Book book) {
        return bookRepository.save(book);
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public void delete(Long id) {
        bookRepository.deleteBookById(id);
    }
}
