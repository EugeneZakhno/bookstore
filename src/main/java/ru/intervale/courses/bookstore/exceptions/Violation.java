package ru.intervale.courses.bookstore.exceptions;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Violation {

    private final String fieldName;
    private final String message;


}
