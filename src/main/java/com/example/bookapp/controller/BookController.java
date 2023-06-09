package com.example.bookapp.controller;


import com.example.bookapp.convert.BookConverter;
import com.example.bookapp.entity.Author;
import com.example.bookapp.entity.Book;
import com.example.bookapp.model.BookRequest;
import com.example.bookapp.model.BookResponse;
import com.example.bookapp.repository.BookRepository;
import com.example.bookapp.service.BookService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("books_admin")
@SecurityRequirement(name = "JWT")
public class BookController {

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
//    @GetMapping
//    public List<Book> findAllByAuthorId (Long authorId) {
//        return bookService.findByAuthorId(authorId);
//    }

    @PostMapping
    public void addBook(@RequestBody BookRequest request) {
        bookService.addBook(converter.convert(request));

    }

    @PutMapping("/{id}")
    public Book editBook(@PathVariable Long id, @RequestBody BookRequest request) {
        return bookService.editBook(converter.convert(id, request));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        bookService.deleteById(id);
    }

}
