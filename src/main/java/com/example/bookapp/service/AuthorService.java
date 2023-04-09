package com.example.bookapp.service;

import com.example.bookapp.convert.BookConverter;
import com.example.bookapp.dto.AuthorRequest;
import com.example.bookapp.entity.Author;
import com.example.bookapp.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;


    public Author getById(Long id) {

        return authorRepository.findById(id).orElseThrow(()->new NotFoundException("Not found such" + id));
    }

    public Author getBySurname(String surname) {
        Author author = authorRepository.findBySurname(surname);
        if (author == null) {
            throw new NotFoundException("Author with surname " +surname+" not found" );
        }
        return author;
    }

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public Author create(AuthorRequest request) {
        Author author = new Author();
        author.setSurname(request.getSurname());
        author.setName((request.getName()));
        return authorRepository.save(author);
    }


    public Author update(Long id, AuthorRequest request) {
        if (!authorRepository.findById(id).isPresent()) {
            throw new NotFoundException("Not found" + id);
        }
        Author author = new Author();
        author.setId(id);
        author.setSurname(request.getSurname());
        author.setName(request.getName());
        return authorRepository.save(author);
    }

    public void delete(Long id) {
        if (!authorRepository.findById(id).isPresent()) {
            throw new NotFoundException("Author with " + id+"not found");
        }
        authorRepository.deleteById(id);
    }


}
