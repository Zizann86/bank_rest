package com.example.bankcards.dto.user;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateUserDto {
    @NotBlank
    @Size(min = 2, max = 250)
    private String name;
    @NotBlank(message = "Пароль не может быть пустым")
    @Size(min = 4, max = 20, message = "Пароль должен быть от 4 до 20 символов")
    private String password;
}
