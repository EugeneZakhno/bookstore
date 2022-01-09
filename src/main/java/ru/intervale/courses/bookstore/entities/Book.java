package ru.intervale.courses.bookstore.entities;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@Builder
public class Book {

    private Long id;
    private String ISBN;
    private String name;
    private String author;
    private String pageNumber;
    private String weight;
    private String price;

}
