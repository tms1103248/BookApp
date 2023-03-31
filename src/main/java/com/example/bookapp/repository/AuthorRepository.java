package com.example.bookapp.repository;

import com.example.bookapp.entity.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AuthorRepository extends CrudRepository<Author,Long> {

    Optional<Author> findByName (String name);
}
