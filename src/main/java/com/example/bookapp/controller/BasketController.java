package com.example.bookapp.controller;

import com.example.bookapp.service.BasketService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("baskets")
@SecurityRequirement(name = "JWT")
public class BasketController {

    private final BasketService basketService;
}
