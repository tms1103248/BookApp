package com.example.bookapp.service;


import com.example.bookapp.entity.Book;
import com.example.bookapp.entity.BookEntity;
import com.example.bookapp.exception.BookNotFoundException;
import com.example.bookapp.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final BookToEntityMapper mapper;

    @Override
    public Book getBookById(Long id) {
        BookEntity bookEntity = bookRepository
                .findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found: id = " + id));

        return mapper.bookEntityToBook(bookEntity);
    }

    @Override
    public List<Book> getAllBooks() {
        Iterable<BookEntity> iterable = bookRepository.findAll();
        return StreamSupport.stream(iterable.spliterator(), false)
                .map(mapper::bookEntityToBook)
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> findByAuthor(String author) {
        Iterable<BookEntity> iterable = bookRepository.findAllByAuthorContaining(author);
        return StreamSupport.stream(iterable.spliterator(), false)
                .map(mapper::bookEntityToBook)
                .collect(Collectors.toList());
    }

    @Override
    public void addBook(Book book) {
        BookEntity bookEntity = mapper.bookToBookEntity(book);
        bookRepository.save(bookEntity);
    }

    @Override
    public void editBook(Book book) {
        if (!bookRepository.existsById(book.getId()))
            throw new BookNotFoundException("Book not found: id = " + book.getId());

        BookEntity bookEntity = mapper.bookToBookEntity(book);
        bookRepository.save(bookEntity);

    }
}
