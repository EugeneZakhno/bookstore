
package ru.intervale.courses.bookstore.service;

import jdk.internal.access.JavaNetUriAccess;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.intervale.courses.bookstore.entities.Book;
import ru.intervale.courses.bookstore.repository.BookRepository;

import javax.swing.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;
import java.util.Timer;

@Service
@Transactional
@AllArgsConstructor
public class BookService  {

    BookRepository bookRepository;

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBook(Long id ) {
        Optional<Book> bookResponse =  bookRepository.findById(id);
        Book book = bookResponse.get();
        return book;
    }

    public HttpResponse findByAuthor(String author) throws URISyntaxException {

        return HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://openlibrary.org/authors/" + author +".json"))
                .GET()
                .build();
        HttpResponse response = httpClient.execute(request);

          return response;
    }

    public List<Book> findByAuthorOpenLibrary(String author) {
        return null;
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
