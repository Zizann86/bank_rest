package com.example.bankcards.service.user;

import com.example.bankcards.dto.user.CreateUserDto;
import com.example.bankcards.dto.user.UserDto;
import com.example.bankcards.entity.User;
import com.example.bankcards.exception.ConflictException;
import com.example.bankcards.repository.UserRepository;
import com.example.bankcards.util.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserDto saveUser(CreateUserDto createUserDto) {
        if (userRepository.findByUsername(createUserDto.getName()).isPresent()) {
            throw new ConflictException("Пользователь с таким именем уже существует");
        }
        User user = userRepository.save(UserMapper.toFromDto(createUserDto));
        log.info("Пользователь успешно создан с id: {}", user.getId());
        return UserMapper.fromToDto(user);
    }
}
