package ru.intervale.courses.bookstore.exceptions;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ValidationErrorResponse {

    private final List<Violation> violations;

}
