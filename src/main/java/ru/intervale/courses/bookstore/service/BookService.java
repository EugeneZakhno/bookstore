
package ru.intervale.courses.bookstore.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import ru.intervale.courses.bookstore.entities.Book;
import ru.intervale.courses.bookstore.repository.BookRepository;

import org.springframework.http.*;

import java.util.List;
import java.util.Optional;

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

    public String findByAuthorOpenLibrary(String author) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("https://openlibrary.org/authors/"+author+".json", String.class);
        return responseEntity.getBody() + "\n" + findByAuthor(author);
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
