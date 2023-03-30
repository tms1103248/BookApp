package com.example.bookapp.model;

import lombok.Data;


@Data
public class BookResponse  {
    Long id;
    String author;
    String title;
    Double price;
}
