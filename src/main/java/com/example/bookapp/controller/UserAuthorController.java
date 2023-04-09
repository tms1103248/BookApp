package com.example.bookapp.controller;

import com.example.bookapp.dto.AuthorRequest;
import com.example.bookapp.entity.Author;
import com.example.bookapp.service.AuthorService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("authors_user")
@SecurityRequirement(name = "JWT")
public class UserAuthorController {

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




}
