package ru.intervale.courses.bookstore.repository;


import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.intervale.courses.bookstore.entities.Book;

import java.sql.ResultSet;
import java.util.List;

@Repository
public interface BookRepository {

    // Маппер, превращающий строку из таблицы БД в объект класса Book
    RowMapper<Book> ROW_MAPPER = (ResultSet resultSet, int rowNum) -> {
        return  Book.builder()
                .id(resultSet.getLong("id"))
                .isbn(resultSet.getString("isbn"))
                .name(resultSet.getString("name"))
                .author(resultSet.getString("author"))
                .pageNumber(resultSet.getInt("page_number"))
                .weight(resultSet.getDouble("weight"))
                .price(resultSet.getBigDecimal("price"))
                .build();
    };

    List<Book> findAll();

    int edit(Long id, Book book);

    int save(Book book);

    void delete(Long id);
}
