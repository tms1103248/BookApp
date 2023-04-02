package com.example.bookapp.convert;



import com.example.bookapp.dto.UserDto;
import com.example.bookapp.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public User convert (UserDto userDto) {
        User user = new User();
        user.setLogin(userDto.getLogin());
        user.setPassword(userDto.getPassword());
        return user;
    }

    public UserDto convert (User user) {
        UserDto userDto =new UserDto();
        userDto.setLogin(user.getLogin());
        userDto.setPassword(user.getPassword());
        userDto.setRoleId(user.getRole().getId());
        return userDto;
    }
}
