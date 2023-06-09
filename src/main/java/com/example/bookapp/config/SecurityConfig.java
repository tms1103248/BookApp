package com.example.bookapp.config;


import com.example.bookapp.jwt.JwtFilter;
import io.swagger.v3.oas.models.PathItem;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtFilter jwtFilter;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // стандартный токен секюритиастройка токена
                .cors().disable() // поомгает ходить с токенами
                .authorizeRequests((auth) -> auth
                        .requestMatchers("/books_user/**").hasRole("USER")
                        .requestMatchers("/books_admin/**").hasRole("ADMIN")//может заходить только юзер
                        .requestMatchers("/auth/**", "/swagger-ui/**", "/v3/api-docs/**")
                        .permitAll().anyRequest()
                        .authenticated().and()
                        .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class));
        return http.build();
    }


}
