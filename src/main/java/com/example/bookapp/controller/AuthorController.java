package com.example.bookapp.controller;

import com.example.bookapp.convert.BookConverter;
import com.example.bookapp.dto.AuthorRequest;
import com.example.bookapp.entity.Author;
import com.example.bookapp.repository.AuthorRepository;
import com.example.bookapp.repository.BookRepository;
import com.example.bookapp.service.AuthorService;
import com.example.bookapp.service.BookService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("authors_admin")
@SecurityRequirement(name = "JWT")
public class AuthorController {

    private final AuthorService authorService;



    @GetMapping("/authors")
    public List<Author> getAllAuthors() {
        return authorService.findAll();
    }

    @GetMapping("/authors/{authorId:\\d+}")
    public Author getAuthorById(@PathVariable ("authorId")Long id) {
        return authorService.getById(id);
    }

    @GetMapping("/authors/{authorSurname:\\D+}")
    public Author getAuthorBySurname(@PathVariable ("authorSurname")String surname) {
        return authorService.getBySurname(surname);
    }

    @PostMapping("/authors")
    public Author createAuthor(@RequestBody AuthorRequest request) {
        return authorService.create(request);
    }

    @PutMapping("/authors/{authorId}")
    public Author updateCountry(@PathVariable("authorId") Long id, @RequestBody AuthorRequest request) {
        return authorService.update(id, request);
    }

    @DeleteMapping("/authors/{authorId}")
    public void deleteAuthor(@PathVariable("authorId") Long id) {
        authorService.delete(id);
    }


}
