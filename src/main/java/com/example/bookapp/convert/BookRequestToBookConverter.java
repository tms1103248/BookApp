package com.example.bookapp.convert;

import com.example.bookapp.entity.Author;
import com.example.bookapp.model.BookRequest;
import org.springframework.stereotype.Component;

@Component
public class BookRequestToBookConverter {
    public Author convert (BookRequest bookRequest) {
        Author book = new Author();
       book.setTitle(bookRequest.getTitle());
        book.setPrice(bookRequest.getPrice());
        return book;
    }

    public Author convert (Long id, BookRequest bookRequest) {
        Author book = new Author();
        book.setId(id);
        book.setAuthor(bookRequest.getAuthor());
        book.setTitle(bookRequest.getTitle());
        book.setPrice(bookRequest.getPrice());

        return book;
    }
}
