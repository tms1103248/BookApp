package com.example.bookapp.service;


import com.example.bookapp.convert.BookConverter;
import com.example.bookapp.convert.BookRequestToBookConverter;
import com.example.bookapp.entity.Book;
import com.example.bookapp.entity.BookEntity;
import com.example.bookapp.exception.BookNotFoundException;
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






    public Book getBookById(Long id) {
        BookEntity bookEntity = bookRepository
                .findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found: id = " + id));

        return converter.convert(bookEntity);
    }


    public List<Book> getAllBooks() {
        Iterable<BookEntity> iterable = bookRepository.findAll();
        return StreamSupport.stream(iterable.spliterator(), false)
                .map(converter::convert)
                .collect(Collectors.toList());
    }


    public List<Book> findByAuthor(String author) {
        Iterable<BookEntity> iterable = bookRepository.findAllByAuthorContaining(author);
        return StreamSupport.stream(iterable.spliterator(), false)
                .map(converter::convert)
                .collect(Collectors.toList());
    }


    public void addBook(Book book) {
        BookEntity bookEntity = converter.convert(book);
        bookRepository.save(bookEntity);
    }


    public void editBook(Book book) {
        if (!bookRepository.existsById(book.getId()))
            throw new BookNotFoundException("Book not found: id = " + book.getId());

        BookEntity bookEntity = converter.convert(book);
        bookRepository.save(bookEntity);

    }


}
