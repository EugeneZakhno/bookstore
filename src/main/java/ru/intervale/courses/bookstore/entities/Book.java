package ru.intervale.courses.bookstore.entities;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ru.intervale.courses.bookstore.util.JsonDeserializer;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Slf4j
@JsonDeserialize(using = JsonDeserializer.class)
@Entity
@Table(name = "book")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

   @Id
   @NotNull
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;

   @Pattern(regexp = "[0-9a-zA-Zа-яА-ЯёЁ -]{0,12}",  message = "Разрешены только латинские буквы и цифры, пробелы и тире")
    private String isbn;

   @Pattern(regexp = "[a-zA-Zа-яА-ЯёЁ '-]{1,256}",  message = "Название не может превышать 255 символов")
    private String name;

   @Pattern(regexp = "[a-zA-Zа-яА-ЯёЁ '-]{1,40}")
    private String author;

    private int pageNumber;

    private double weight;

    @NotNull
    private BigDecimal price;

//    public Book(@NotNull Long id, @Pattern(regexp = "[0-9a-zA-Zа-яА-ЯёЁ -]{0,12}",
//            message = "Разрешены только латинские буквы и цифры, пробелы и тире") String isbn,
//                @Pattern(regexp = "[a-zA-Zа-яА-ЯёЁ '-]{1,256}", message = "Название не может превышать 255 символов")
//                        String name,
//                        @Pattern(regexp = "[a-zA-Zа-яА-ЯёЁ '-]{1,40}") String author,
//                        int pageNumber,
//                        double weight,
//                         @NotNull BigDecimal price) {
//        this.id = id;
//        this.isbn = isbn;
//        this.name = name;
//        this.author = author;
//        this.pageNumber = pageNumber;
//        this.weight = weight;
//        this.price = price;
//    }
}
