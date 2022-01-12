package ru.intervale.courses.bookstore.entities;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Slf4j
@Data
@Builder
public class Book {

    private Long id;
    private String ISBN;
    private String name;
    private String author;
    private int pageNumber;
    private double weight;
    private BigDecimal price;

}
