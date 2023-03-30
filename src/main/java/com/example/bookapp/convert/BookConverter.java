package com.example.bookapp.convert;

import com.example.bookapp.entity.Author;
import com.example.bookapp.entity.Book;
import com.example.bookapp.model.BookRequest;
import com.example.bookapp.repository.AuthorRepository;
import org.springframework.stereotype.Component;

@Component
public class BookConverter {

    private final AuthorRepository authorRepository;

    public Book convert (BookRequest book) {
        Book response = new Book();

        response.setPrice(book.getPrice());
        return response;
    }

    public Book convert(Long id, BookRequest bookRequest) {
        Book book = new Book();
        book.setId(id);

        book.setTitle(bookRequest.getTitle());
        book.setPrice(bookRequest.getPrice());
        return book;
    }

}
