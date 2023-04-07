package com.example.bookapp.convert;

import com.example.bookapp.entity.Author;
import com.example.bookapp.entity.Book;
import com.example.bookapp.model.BookRequest;
import com.example.bookapp.model.BookResponse;
import com.example.bookapp.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BookConverter {

    private final AuthorRepository authorRepository;

    public Book convert (BookRequest book) {
        Book response = new Book();

        response.setPrice(book.getPrice());
        Author author = authorRepository.findByName(book.getAuthor()).orElseThrow();
        response.setAuthor(author);
        response.setTitle(book.getTitle());
        return response;
    }

    public Book convert(Long id, BookRequest bookRequest) {
        Book book = new Book();
        book.setId(id);

        Author author=authorRepository.findByName(bookRequest.getAuthor()).orElseThrow();
        book.setAuthor(author);
        book.setTitle(bookRequest.getTitle());
        book.setPrice(bookRequest.getPrice());
        return book;
    }

    public BookResponse convert (Book book) {
        BookResponse response =new BookResponse();
        response.setId(book.getId());
        response.setTitle(book.getTitle());
        response.setPrice(book.getPrice());
        response.setAuthor(book.getAuthor().getName());
        return response;

    }
    public List<BookResponse> convert (List<Book> books) {
        return books.stream().map(this::convert).toList();
    }

}
