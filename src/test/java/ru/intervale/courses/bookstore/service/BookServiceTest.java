package ru.intervale.courses.bookstore.service;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.intervale.courses.bookstore.entities.Book;
import ru.intervale.courses.bookstore.repository.BookRepository;

import java.math.BigDecimal;

import static org.mockito.Mockito.verify;



@ExtendWith(MockitoExtension.class)
class BookServiceTest {

  @Mock  private BookRepository bookRepository;
  private BookService bookService;

  @BeforeEach
  void setUp() {
    bookService = new BookService(bookRepository);
  }

  @Test
  void canGetAllbooks() {
    bookService.findAllBooks();
    verify(bookRepository).findAll();
  }

  @Test
  void canAddStudent() {
    // given
    Book book = new Book(9L,"dfdhgb-ery", "Mockito In Action","ALAN", 500, 321.02,
                                     BigDecimal.valueOf(474.25));
    // when
    bookService.save(book);
    // then

  }

//
 // @Test
 // public void saveMock(){
//
 //   Book book1 = new Book(9L,"dfdhgb-ery", "Mockito In Action","ALAN", 500, 321.02,
 //                           BigDecimal.valueOf(474.25));
//
 //   Book book2 = new Book(9L,"dfdhgb-ery", "JUnit 5 In Action","Moris", 520, 421.02,
 //           BigDecimal.valueOf(874.25));
//
//
 // }
//

}