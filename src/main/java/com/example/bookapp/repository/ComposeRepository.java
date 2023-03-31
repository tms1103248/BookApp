package com.example.bookapp.repository;


import com.example.bookapp.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComposeRepository extends JpaRepository<Book,Long> {
}
