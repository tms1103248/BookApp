package com.example.bookapp.repository;

import com.example.bookapp.entity.Author;
import com.example.bookapp.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface BookRepository extends CrudRepository<Book, Long> {


    List<Book> findAllByAuthorSurnameContaining(String author);

//    List<Book> findAllByAuthorId (Long id);




}