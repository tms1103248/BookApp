package com.example.bookapp.security;


import com.example.bookapp.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {
    // аналог предыдущего юзера
    private String login;
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public static CustomUserDetails getUserDetailsFromUser(User user) {
        CustomUserDetails userDetails = new CustomUserDetails();
        userDetails.login = user.getLogin();
        userDetails.password = user.getPassword();
        userDetails.authorities = Collections
                .singletonList(new SimpleGrantedAuthority(user.getRole()
                        .getName()));
        return userDetails;

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // логин и пароль
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
