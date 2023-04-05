package com.example.bookapp.controller;


import com.example.bookapp.convert.BookConverter;
import com.example.bookapp.entity.Author;
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
@RequestMapping("books")
@SecurityRequirement(name = "JWT")
public class BookController {

    private final BookService bookService;


    private final BookConverter converter;


//    @GetMapping
//    public String showBookForm () {
//        return "adminPage";
//    }

    @GetMapping("/{id}")
    public BookResponse getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @GetMapping("getAllBooks")
    public List<BookResponse> getAllBooks(@RequestParam(required = false) String author) {
        if (author != null)
            return bookService.findByAuthor(author);

        return bookService.getAllBooks();
    }

    @PostMapping("addBook")
    public String addBook(@RequestBody BookRequest request) {
        bookService.addBook(converter.convert(request));
        return "redirect:/books/booklist";
    }

    @PutMapping("/{editBook}")
    public void editBook(@PathVariable Long id, @RequestBody BookRequest request) {
        bookService.editBook(converter.convert(id, request));
    }


}
