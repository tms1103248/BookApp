package com.example.bookapp.convert;

import com.example.bookapp.entity.Book;
import com.example.bookapp.entity.BookEntity;
import com.example.bookapp.model.BookRequest;
import com.example.bookapp.model.BookResponse;
import org.springframework.stereotype.Component;

@Component
public class BookConverter {

    public Book convert (Book books) {
        return books.stream().map(this::convert).toList();
    }



    public Book convert(Book book) {
        BookResponse response = new BookResponse();
        response.setId(book.getId());
        response.setAuthor(book.getAuthor());
        response.setPrice(book.getPrice());
        return response;
    }


    public Book AddBookRequestToBook(BookRequest request) {
    }

    public Book EditBookRequestToBook(Long id, BookRequest request) {
    }
}
