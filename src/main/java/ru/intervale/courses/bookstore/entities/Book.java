package ru.intervale.courses.bookstore.entities;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
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
   @Column (name = "id")
   private Long id;

    @Column (name = "isbn")
   @Pattern(regexp = "[0-9a-zA-Zа-яА-ЯёЁ -]{0,12}",  message = "Разрешены только латинские буквы и цифры, пробелы и тире")
    private String isbn;

    @Column (name = "name")
   @Pattern(regexp = "[a-zA-Zа-яА-ЯёЁ '-]{1,256}",  message = "Название не может превышать 255 символов")
    private String name;

    @Column (name = "author")
    @Pattern(regexp = "[0-9a-zA-Zа-яА-ЯёЁ '-]{1,40}")
    private String author;

    @Column (name = "page_number")
    private int pageNumber;

    @Column (name = "weight")
    private double weight;

    @NotNull
    @Column (name = "price")
    private BigDecimal price;

    @NotNull
    @Column (name = "currency")
    private String currency;

}
