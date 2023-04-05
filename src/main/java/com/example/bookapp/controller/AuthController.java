package com.example.bookapp.controller;



import com.example.bookapp.dto.AuthRequest;
import com.example.bookapp.dto.AuthResponse;
import com.example.bookapp.entity.User;
import com.example.bookapp.jwt.JwtTokenUtil;
import com.example.bookapp.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@SecurityRequirement(name = "JWT")
public class AuthController {

    private final UserService userService;
    private final JwtTokenUtil tokenUtil;

    @PostMapping("registration")
    public void createUser(@RequestBody AuthRequest authRequest) {
        userService.save(authRequest);
    }

    @PostMapping("login")
    public AuthResponse login(@RequestBody AuthRequest authRequest) {
        User user =userService.getTokenForUserIfExists(authRequest);
        return new AuthResponse(tokenUtil.generateToken(user.getLogin()));

    }


}
