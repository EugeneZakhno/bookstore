package ru.intervale.courses.bookstore.service;

import org.springframework.jdbc.core.RowMapper;
import ru.intervale.courses.bookstore.entities.Book;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper implements RowMapper<Book> {

    @Override
    public Book mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Book(
                resultSet.getLong("id"),
                resultSet.getString("isbn"),
                resultSet.getString("name"),
                resultSet.getString("author"),
                resultSet.getInt("page_number"),
                resultSet.getDouble("weight"),
                resultSet.getBigDecimal("price")

        );
    }
}