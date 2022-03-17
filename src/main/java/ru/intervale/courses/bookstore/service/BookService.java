
package ru.intervale.courses.bookstore.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.intervale.courses.bookstore.entities.Book;
import ru.intervale.courses.bookstore.repository.BookRepository;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
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

    public HttpResponse<String> findByAuthor(String author) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();

      //  Book book = new Book(1, "Java HttpClient in practice");
       // String body = objectMapper.writeValueAsString(book);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(" https://openlibrary.org/authors/"+author+".json"))
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .GET()
               // .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
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
