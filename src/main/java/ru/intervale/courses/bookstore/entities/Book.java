package ru.intervale.courses.bookstore.entities;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import ru.intervale.courses.bookstore.util.JsonDeserializer;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Slf4j
@Data
@Builder
@JsonDeserialize(using = JsonDeserializer.class)
public class Book {

    @NotNull
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

    public Book(@NotNull Long id, @Pattern(regexp = "[0-9a-zA-Zа-яА-ЯёЁ -]{0,12}",
            message = "Разрешены только латинские буквы и цифры, пробелы и тире") String isbn,
                @Pattern(regexp = "[a-zA-Zа-яА-ЯёЁ '-]{1,256}", message = "Название не может превышать 255 символов")
                        String name,
                        @Pattern(regexp = "[a-zA-Zа-яА-ЯёЁ '-]{1,40}") String author,
                        int pageNumber,
                        double weight,
                         @NotNull BigDecimal price) {
        this.id = id;
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.pageNumber = pageNumber;
        this.weight = weight;
        this.price = price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Book: ");
        sb.append("id=").append(id);
        sb.append(", isbn='").append(isbn).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", author=").append(author);
        sb.append(", pageNumber='").append(pageNumber).append('\'');
        sb.append(", weight='").append(weight).append('\'');
        sb.append(", price='").append(price).append('\'');
        return sb.toString() + "\n" ;
    }
}
