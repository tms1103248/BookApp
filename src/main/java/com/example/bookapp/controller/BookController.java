package com.example.bookapp.controller;


import com.example.bookapp.convert.BookConverter;
import com.example.bookapp.entity.Book;
import com.example.bookapp.entity.BookEntity;
import com.example.bookapp.model.BookRequest;
import com.example.bookapp.service.BookService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("books")
public class BookController {

    private final BookService bookService;


    private final BookConverter converter;

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @GetMapping
    public List<Book> getAllBooks(@RequestParam(required = false) String author) {
        if (author != null)
            return bookService.findByAuthor(author);

        return bookService.getAllBooks();
    }

    @PostMapping
    public void addBook(@RequestBody BookRequest request) {
        bookService.addBook(converter.AddBookRequestToBook(request));
    }

    @PutMapping("/{id}")
    public void editBook(@PathVariable Long id, @RequestBody BookRequest request) {
        bookService.editBook(converter.EditBookRequestToBook(id, request));
    }

}
