package com.example.bookapp.service;


import com.example.bookapp.convert.UserConverter;
import com.example.bookapp.dto.AuthRequest;
import com.example.bookapp.dto.UserDto;
import com.example.bookapp.entity.Role;
import com.example.bookapp.entity.User;
import com.example.bookapp.repository.RoleRepository;
import com.example.bookapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    private final UserConverter converter;




    public void save (AuthRequest request) {
        UserDto userDto = new UserDto();
        userDto.setRoleId(1L);
        userDto.setLogin(request.getLogin());
        userDto.setPassword(request.getPassword());
        save(userDto);

    }

    @Transactional
    public UserDto save(UserDto userDto) {
        long roleId = userDto.getRoleId();
        Role role = roleRepository
                .findById(roleId)
                .orElseThrow();

        User user = converter.convert(userDto);
        user.setRole(role);
        user.setPassword(passwordEncoder.encode(user.getPassword())); // пароль станет абракадаброй
        userRepository.save(user);
        return converter.convert(user);

    }

    public Optional<User> findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    public User getTokenForUserIfExists (AuthRequest authRequest) {
        return findByLoginAndPassword(authRequest.getLogin() ,authRequest.getPassword())
                .orElseThrow();


    }


    public Optional<User> findByLoginAndPassword (String login,String password) {
        User user =findByLogin(login).orElseThrow();
        if (passwordEncoder.matches(password, user.getPassword())) {
            return Optional.of(user); // вернем юзера если только совпадает пароль в остальных случаях бросит null
        }
        return Optional.empty();
    }

}
