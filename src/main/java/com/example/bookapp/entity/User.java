package com.example.bookapp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true) //создаем уникальный логин
    private String login;

    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

//    @OneToMany
//    private Basket basket;

}
