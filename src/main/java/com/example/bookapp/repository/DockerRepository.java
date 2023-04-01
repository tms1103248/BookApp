package com.example.bookapp.repository;


import com.example.bookapp.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DockerRepository extends JpaRepository<Author,Long> {
}
