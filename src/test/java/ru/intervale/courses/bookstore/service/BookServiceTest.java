package ru.intervale.courses.bookstore.service;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.intervale.courses.bookstore.entities.Book;

import java.math.BigDecimal;

import static org.mockito.Mockito.mock;


@AllArgsConstructor
@ExtendWith(MockitoExtension.class)
class BookServiceTest {

  private final BookService bookService;

  private static final String isbn = "lkfjg-dfgg";
  private static final Book book= mock(Book.class);

  @Test
  public void saveMock(){

    Book book1 = new Book(9L,"dfdhgb-ery", "Mockito In Action","ALAN", 500, 321.02,
                            BigDecimal.valueOf(474.25));

    Book book2 = new Book(9L,"dfdhgb-ery", "JUnit 5 In Action","Moris", 520, 421.02,
            BigDecimal.valueOf(874.25));

  }


  @Test
  void save() {
  }


    @Test
    void findAll() {

    }


    @Test
    void delete() {
    }

    @Test
    void edit() {
    }
}