
package ru.intervale.courses.bookstore.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.intervale.courses.bookstore.entities.Book;
import ru.intervale.courses.bookstore.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookService  {

    BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

 //  public Book edit(Long id, Book book) {
 //      return bookRepository.edit(id, book );
 //  }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

 //  public void delete(Long id) {
 //    bookRepository.delete(id);
 //  }
}
