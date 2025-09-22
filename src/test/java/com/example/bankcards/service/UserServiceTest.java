package com.example.bankcards.service;

import com.example.bankcards.dto.user.CreateUserDto;
import com.example.bankcards.dto.user.UserDto;
import com.example.bankcards.entity.Role;
import com.example.bankcards.entity.User;
import com.example.bankcards.exception.ConflictException;
import com.example.bankcards.repository.UserRepository;
import com.example.bankcards.service.user.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private final CreateUserDto createUserDto = new CreateUserDto("Ivan", "password123");
    private final User savedUser = User.builder()
            .id(1L)
            .name("Ivan")
            .password("password123")
            .role(Role.USER)
            .cards(new ArrayList<>())
            .build();

    @Test
    void saveUser_shouldCreateNewUser() {
        when(userRepository.findByUsername("Ivan")).thenReturn(Optional.empty());
        when(userRepository.save(any(User.class))).thenReturn(savedUser);

        UserDto result = userService.saveUser(createUserDto);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Ivan", result.getName());
        assertEquals(Role.USER, result.getRole());
        assertNull(result.getPassword());
        assertTrue(result.getCards().isEmpty());

        verify(userRepository).findByUsername("Ivan");
        verify(userRepository).save(argThat(user ->
                user.getName().equals("Ivan") &&
                        user.getPassword().equals("password123") &&
                        user.getRole() == Role.USER &&
                        user.getCards().isEmpty()
        ));
    }

    @Test
    void saveUser_shouldThrowConflictExceptionWhenUserExists() {
        User existingUser = User.builder()
                .id(2L)
                .name("Ivan")
                .password("existingPass")
                .build();

        when(userRepository.findByUsername("Ivan")).thenReturn(Optional.of(existingUser));

        ConflictException exception = assertThrows(ConflictException.class,
                () -> userService.saveUser(createUserDto));

        assertEquals("Пользователь с таким именем уже существует", exception.getMessage());

        verify(userRepository, never()).save(any(User.class));
        verify(userRepository).findByUsername("Ivan");
    }
}