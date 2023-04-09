package com.example.bookapp.controller;


import com.example.bookapp.convert.BookConverter;
import com.example.bookapp.entity.Book;
import com.example.bookapp.model.BookRequest;
import com.example.bookapp.model.BookResponse;
import com.example.bookapp.service.BookService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("books_user")
@SecurityRequirement(name = "JWT")
public class UserBooksController {

    private final BookService bookService;


    private final BookConverter converter;



    @GetMapping("/{id}")
    public BookResponse getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }


    @GetMapping
    public List<BookResponse> getAllBooks(@RequestParam(required = false) String author) {
        if (author != null)
            return bookService.findByAuthor(author);
        return bookService.getAllBooks();
    }





}
