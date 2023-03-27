package com.example.bookapp.repository;

import com.example.bookapp.entity.Book;
import com.example.bookapp.entity.BookEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends CrudRepository<BookEntity, Long> {


    List<BookEntity> findAllByAuthorContaining(String author);




}