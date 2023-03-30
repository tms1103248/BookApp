package com.example.bookapp.convert;

import com.example.bookapp.entity.Author;
import com.example.bookapp.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookConverter {

    public Author convert (Book book) {
        Author response = new Author();
        response.setId(book.getId());
        response.setAuthor(book.getAuthor());
        response.setPrice(book.getPrice());
        return response;
    }

    public Book convert(Author book) {
        Book response = new Book();
        response.setId(book.getId());
        response.setAuthor(book.getAuthor());
        response.setPrice(book.getPrice());
        return response;
    }

}
