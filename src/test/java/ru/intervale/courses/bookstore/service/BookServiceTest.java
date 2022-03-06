package ru.intervale.courses.bookstore.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.intervale.courses.bookstore.entities.Book;
import ru.intervale.courses.bookstore.repository.BookRepository;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
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
  void canAddBook() {
    // given
    Book book = new Book(9L,"dfdhgb-ery", "Mockito In Action","ALAN", 500, 321.02,
                                     BigDecimal.valueOf(474.25));
    // when
    bookService.save(book);
    // then
      ArgumentCaptor<Book> bookArgumentCaptor = ArgumentCaptor.forClass(Book.class);
      verify(bookRepository).save(bookArgumentCaptor.capture());
      Book capturedBook = bookArgumentCaptor.getValue();
      assertThat(capturedBook).isEqualTo(book);
  }

  @Test
  void canEditBook() {
    // given
    Book book = new Book(15L,"dfdhgb-ery", "Mockito In Action","ALAN", 500, 321.02,
            BigDecimal.valueOf(474.25));
    // when
    bookService.save(book);
    // Then
    verify(bookRepository).save(book);
  }

  @Test
  void canFindBookById() {
    // given
    Book book = new Book(10L,"dfdhgb-ery", "Mockito In Action","ALAN", 500, 321.02,
            BigDecimal.valueOf(474.25));
    // when
    bookService.findById(book.getId());
    // Then
    verify(bookRepository).findById(book.getId());
  }

  @Test
  void canDeleteBook() {
    // given
    Book book = new Book(11L,"dfdhgb-ery", "Mockito In Action","ALAN", 500, 321.02,
            BigDecimal.valueOf(474.25));
    // when
    bookService.delete(book.getId());
    // Then
    verify(bookRepository).deleteBookById(book.getId());
  }

}