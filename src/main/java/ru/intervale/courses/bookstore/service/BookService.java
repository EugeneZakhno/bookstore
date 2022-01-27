
package ru.intervale.courses.bookstore.service;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ru.intervale.courses.bookstore.entities.Book;
import ru.intervale.courses.bookstore.repository.BookRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService implements BookRepository {

    private final JdbcTemplate jdbcTemplate;


    @Override
    public List<Book> findAll() {
        return jdbcTemplate.query("SELECT * FROM book;", new BookRowMapper());
    }

    @Override
    public int save(Book book) {
        return jdbcTemplate.update("INSERT INTO book(id, isbn,name,author,page_number, weight, price)VALUES (?, ?);",
                book.getId(), book.getIsbn(), book.getName(), book.getAuthor(), book.getPageNumber(), book.getWeight(),
                book.getPrice());
    }


    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM Person WHERE id=?;", id);
    }

    @Override
    public int edit(Long id, Book book) {
        return jdbcTemplate.update("UPDATE Book SET id=?, isbn=?, name=?, author=?, pageNumber=?, weight=?, price=?"
                        + "WHERE id=?",
                book.getId(), book.getIsbn(), book.getName(), book.getAuthor(), book.getPageNumber(), book.getWeight(),
                book.getPrice());

    }


}
