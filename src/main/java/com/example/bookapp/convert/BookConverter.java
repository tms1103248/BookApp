package com.example.bookapp.convert;

import com.example.bookapp.entity.Book;
import com.example.bookapp.entity.BookEntity;
import com.example.bookapp.model.BookRequest;
import com.example.bookapp.model.BookResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookConverter {

    public Book convert (BookEntity book) {
        Book response = new Book();
        response.setId(book.getId());
        response.setAuthor(book.getAuthor());
        response.setPrice(book.getPrice());
        return response;
    }

    public BookEntity convert(Book book) {
        BookEntity response = new BookEntity();
        response.setId(book.getId());
        response.setAuthor(book.getAuthor());
        response.setPrice(book.getPrice());
        return response;
    }
//    public BookRequest convert (Book book) {
//        BookRequest request = new BookRequest();
//
//        request.setAuthor(book.getAuthor());
//        request.setPrice(book.getPrice());
//        return request;
//    }
//    public Book convert2 (BookRequest book) {
//        Book request = new Book();
//        request.setId(book.getId());
//        request.setAuthor(book.getAuthor());
//        request.setPrice(book.getPrice());
//        return request;
//    }
//
//    public Book convert(Long id, BookRequest request) {
//    }
//

//    public Book AddBookRequestToBook(BookRequest request) {
//    }
//
//    public Book EditBookRequestToBook(Long id, BookRequest request) {
//    }
}
