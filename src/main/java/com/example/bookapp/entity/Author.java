package com.example.bookapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "author")
public class Author {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String surname;


    @OneToMany(mappedBy = "book", orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Book> book = new HashSet<>();


}
