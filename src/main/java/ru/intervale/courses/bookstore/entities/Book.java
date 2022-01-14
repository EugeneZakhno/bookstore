package ru.intervale.courses.bookstore.entities;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Slf4j
@Data
@Builder
public class Book {

    @NotNull
    private Long id;

    @Pattern(regexp = "[0-9a-zA-Zа-яА-ЯёЁ -]{0,12}",  message = "Разрешены только латинские буквы и цифры")
    private String isbn;

    @Pattern(regexp = "[a-zA-Zа-яА-ЯёЁ '-]{1,256}",  message = "Название не может превышать 255 символов")
    private String name;

    @Pattern(regexp = "[a-zA-Zа-яА-ЯёЁ '-]{1,40}")
    private String author;

    private int pageNumber;

    private double weight;

    @NotNull
    private BigDecimal price;

}
