package com.example.bankcards.dto.user;

import com.example.bankcards.entity.Card;
import com.example.bankcards.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDto {
    private Long id;
    private String name;
    private String password;
    private Role role;
    private List<Card> cards;
}
