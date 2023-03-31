package com.example.bookapp.service;


import com.example.bookapp.convert.BookConverter;
import com.example.bookapp.entity.Author;
import com.example.bookapp.entity.Book;
import com.example.bookapp.exception.BookNotFoundException;
import com.example.bookapp.model.BookResponse;
import com.example.bookapp.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
@Slf4j
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final BookConverter converter;

    public BookResponse getBookById(Long id) {
        Book book = bookRepository
                .findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found: id = " + id));
        return converter.convert(book);
    }


    public List<BookResponse> getAllBooks() {
        Iterable<Book> iterable = bookRepository.findAll();
        return StreamSupport.stream(iterable.spliterator(), false)
                .map(converter::convert)
                .collect(Collectors.toList());
    }


    public List<BookResponse> findByAuthor(String author) {
        Iterable<Book> iterable = bookRepository.findAllByAuthorContaining(author);
        return StreamSupport.stream(iterable.spliterator(), false)
                .map(converter::convert)
                .collect(Collectors.toList());
    }


    public void addBook(Book author) {

        bookRepository.save(author);
    }


    public void editBook(Book author) {
        if (!bookRepository.existsById(author.getId()))
            throw new BookNotFoundException("Book not found: id = " + author.getId());


        bookRepository.save(author);

    }


}
