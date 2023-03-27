package com.example.bookapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book  {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String author;
    private String title;
    private Double price;

    @OneToMany(mappedBy = "book", orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<BookEntity> bookEntity = new HashSet<>();



}
