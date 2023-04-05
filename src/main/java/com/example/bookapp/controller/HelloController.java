package com.example.bookapp.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@SecurityRequirement(name = "JWT")
public class HelloController {

    @GetMapping
    public String getHelloPage () {
        return "adminPage";
    }



}
