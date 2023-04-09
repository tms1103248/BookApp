package com.example.bookapp.dto;

import lombok.Data;

@Data
public class AuthorRequest {
    private String surname;
    private String name;

    public String getSurname() {
        return surname;
    }
    public String getName() {return name;}

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
