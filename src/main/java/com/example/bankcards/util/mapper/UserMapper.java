package com.example.bankcards.util.mapper;

import com.example.bankcards.dto.user.CreateUserDto;
import com.example.bankcards.dto.user.UserDto;
import com.example.bankcards.entity.Role;
import com.example.bankcards.entity.User;

import java.util.ArrayList;

public class UserMapper {

    /*public static User toFromDto(CreateUserDto createUserDto) {
        return User.builder()
                .name(createUserDto.getName())
                .password(createUserDto.getPassword())
                .build();
    }*/

    public static User toFromDto(CreateUserDto createUserDto) {
        return User.builder()
                .name(createUserDto.getName())
                .password(createUserDto.getPassword())
                .role(Role.USER)                 // ← добавьте это
                .cards(new ArrayList<>())        // ← и это
                .build();
    }

    public static UserDto fromToDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                //.password(user.getPassword())
                .password(null)
                .role(user.getRole())
                .cards(user.getCards())
                .build();
    }

    public static UserResponseDto fromToResponseDto(User user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .name(user.getName())
                .build();
    }
}
