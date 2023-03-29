package com.example.bookapp.convert;

import com.example.bookapp.entity.Book;
import com.example.bookapp.model.BookRequest;
import org.springframework.stereotype.Component;

@Component
public class BookRequestToBookConverter {
    public Book convert (BookRequest bookRequest) {
        Book book = new Book();
       book.setTitle(bookRequest.getTitle());
        book.setPrice(bookRequest.getPrice());
        return book;
    }

    public Book convert (Long id,BookRequest bookRequest) {
        Book book = new Book();
        book.setId(id);
        book.setAuthor(bookRequest.getAuthor());
        book.setTitle(bookRequest.getTitle());
        book.setPrice(bookRequest.getPrice());

        return book;
    }
}
