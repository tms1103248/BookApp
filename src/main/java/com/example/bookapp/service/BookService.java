package com.example.bookapp.service;


import com.example.bookapp.convert.BookConverter;
import com.example.bookapp.entity.Author;
import com.example.bookapp.entity.Book;
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






    public Author getBookById(Long id) {
        Book book = bookRepository
                .findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found: id = " + id));

        return converter.convert(book);
    }


    public List<Author> getAllBooks() {
        Iterable<Book> iterable = bookRepository.findAll();
        return StreamSupport.stream(iterable.spliterator(), false)
                .map(converter::convert)
                .collect(Collectors.toList());
    }


    public List<Author> findByAuthor(String author) {
        Iterable<Book> iterable = bookRepository.findAllByAuthorContaining(author);
        return StreamSupport.stream(iterable.spliterator(), false)
                .map(converter::convert)
                .collect(Collectors.toList());
    }


    public void addBook(Author author) {
        Book bookEntity = converter.convert(author);
        bookRepository.save(bookEntity);
    }


    public void editBook(Author author) {
        if (!bookRepository.existsById(author.getId()))
            throw new BookNotFoundException("Book not found: id = " + author.getId());

        Book bookEntity = converter.convert(author);
        bookRepository.save(bookEntity);

    }


}
