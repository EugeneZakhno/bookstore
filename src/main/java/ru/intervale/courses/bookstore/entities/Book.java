package ru.intervale.courses.bookstore.entities;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

@Slf4j
@Data
@Builder
public class Book {

    @NotBlank
    private Long id;

    @Pattern(regexp = "[0-9A-Za-z]{18}",  message = "Разрешены только латинские буквы и цифры")
    private String ISBN;

    @Pattern(regexp = "[a-zA-Zа-яА-ЯёЁ '-]{1,256}",  message = "Название не может превышать 255 символов")
    private String name;

    @Pattern(regexp = "[a-zA-Zа-яА-ЯёЁ '-]{1,40}")
    private String author;

    private int pageNumber;

    private double weight;

    @Min(5)
    @Max(1000)
    private BigDecimal price;

}
