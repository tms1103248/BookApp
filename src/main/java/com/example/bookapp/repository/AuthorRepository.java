package com.example.bookapp.repository;

import com.example.bookapp.entity.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface AuthorRepository extends CrudRepository<Author,Long> {

    Optional<Author> findByName (String name);
    Author findBySurname(String surname);
    List<Author> findAll();

//   Optional<Author> findById(Long id);

//    boolean exists(Long id);
//
    void deleteById(Long id);
}
