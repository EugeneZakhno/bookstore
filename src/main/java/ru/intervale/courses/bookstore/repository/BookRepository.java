package ru.intervale.courses.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.intervale.courses.bookstore.entities.Book;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAll();

    Optional<Book> findById(Long id);

    List<Book> findByAuthor(String author);

    Book save(Book book);

    void deleteBookById(Long id);
}
