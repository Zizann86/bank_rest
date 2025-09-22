package com.example.bankcards.controller.admin;

import com.example.bankcards.dto.user.CreateUserDto;
import com.example.bankcards.dto.user.UserDto;
import com.example.bankcards.service.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/admin/users")
@RequiredArgsConstructor
public class UserAdminController {
    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto saveUser(@Valid @RequestBody CreateUserDto createUserDto) {
        log.info("Получен HTTP-запрос на добавление пользователя: {}", createUserDto);
        return userService.saveUser(createUserDto);
    }
}
