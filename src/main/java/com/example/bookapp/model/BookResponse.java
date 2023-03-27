package com.example.bookapp.model;

import lombok.Value;


@Value
public class BookResponse {
    Long id;
    String author;
    String title;
    Double price;
}
