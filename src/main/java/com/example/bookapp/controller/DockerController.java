package com.example.bookapp.controller;


import com.example.bookapp.entity.Author;
import com.example.bookapp.repository.DockerRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("test")
@SecurityRequirement(name = "JWT")
public class DockerController {
    private final DockerRepository dockerRepository;

    @GetMapping
    public List<Author> findAll(){
        return dockerRepository.findAll();
    }

    @PostMapping
    public void create (@RequestBody String comment) {

        Author author = new Author();
        author.setName(comment);
        author.setSurname(comment);
        dockerRepository.save(author);
//        с фронта приняли данные и сохранили в базу
    }



}
