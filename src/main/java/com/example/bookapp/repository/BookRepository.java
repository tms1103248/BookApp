package com.example.bookapp.repository;

import com.example.bookapp.entity.Author;
import com.example.bookapp.entity.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {


    List<Book> findAllByAuthorContaining(String author);



}