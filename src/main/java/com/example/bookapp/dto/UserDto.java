package com.example.bookapp.dto;

import lombok.Data;

@Data
public class UserDto {

    private String login;

    private String password;

    private Long roleId;
}
