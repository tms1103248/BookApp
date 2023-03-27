package com.example.bookapp.model;

import com.example.bookapp.entity.Book;
import lombok.Data;
import lombok.Value;


@Data
public class BookResponse  {
    Long id;
    String author;
    String title;
    Double price;
}
