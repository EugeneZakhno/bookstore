
package ru.intervale.courses.bookstore.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;
import ru.intervale.courses.bookstore.entities.Book;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService extends JdbcDaoSupport {

    final String url = "jdbc:postgresql://ec2-34-242-89-204.eu-west-1.compute.amazonaws.com:5432/d4fs7m9uvscsn1";
    final String user = "pwfsxwzkaphztb";
    final String password = "0411039f232bb00ecaea0259e193981fb4ff8a5e7b1ef21d9dd8183c47cf00a8";

    public BookService(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    List<Book> result = new ArrayList<>();

    String SQL_SELECT = "SELECT * FROM book";
    String SQL_INSER =  "INSERT INTO book VALUES id = ?, isbn=?, name=?, author=?, page_number=?, weight=?, price=?";
    String SQL_UPDATE = "UPDATE book SET id = ?, isbn=?, name=?, author=?, page_number=?, weight=?, price=?";
    String SQL_DELETE = "DELETE FROM book WHERE id = ?";

    public Book addBook(Book book) {

        try (Connection connect = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connect.prepareStatement(SQL_INSER)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String isbn = resultSet.getString("isbn");
                String name = resultSet.getString("name");
                String author = resultSet.getString("author");
                int pageNumber = resultSet.getInt("page_number");
                double weight = resultSet.getDouble("weight");
                BigDecimal price = resultSet.getBigDecimal("price");

                book = Book.builder()
                        .id(id)
                        .isbn(isbn)
                        .name(name)
                        .author(author)
                        .pageNumber(pageNumber)
                        .weight(weight)
                        .price(price)
                        .build();
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        return book;
    }


    public List<Book> getAllBook() {
        try (Connection connect = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connect.prepareStatement(SQL_SELECT)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String isbn = resultSet.getString("isbn");
                String name = resultSet.getString("name");
                String author = resultSet.getString("author");
                int pageNumber = resultSet.getInt("page_number");
                double weight = resultSet.getDouble("weight");
                BigDecimal price = resultSet.getBigDecimal("price");

                Book book = Book.builder()
                        .id(id)
                        .isbn(isbn)
                        .name(name)
                        .author(author)
                        .pageNumber(pageNumber)
                        .weight(weight)
                        .price(price)
                        .build();
                result.add(book);
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        return result;
    }

    public Book editBook(Book book) {

        try (Connection connect = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connect.prepareStatement(SQL_UPDATE)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String isbn = resultSet.getString("isbn");
                String name = resultSet.getString("name");
                String author = resultSet.getString("author");
                int pageNumber = resultSet.getInt("page_number");
                double weight = resultSet.getDouble("weight");
                BigDecimal price = resultSet.getBigDecimal("price");

                book = Book.builder()
                        .id(id)
                        .isbn(isbn)
                        .name(name)
                        .author(author)
                        .pageNumber(pageNumber)
                        .weight(weight)
                        .price(price)
                        .build();
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        return book;
    }

    public void deleteBook(Long id) {
        try (Connection connect = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connect.prepareStatement(SQL_DELETE)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getLong("id");
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }

}
