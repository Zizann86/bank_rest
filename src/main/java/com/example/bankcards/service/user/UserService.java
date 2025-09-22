package com.example.bankcards.service.user;

import com.example.bankcards.dto.user.CreateUserDto;
import com.example.bankcards.dto.user.UserDto;

public interface UserService {

    UserDto saveUser(CreateUserDto createUserDto);
}
