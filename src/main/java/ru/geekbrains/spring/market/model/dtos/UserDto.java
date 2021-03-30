package ru.geekbrains.spring.market.model.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.spring.market.model.entities.User;

@Data
@NoArgsConstructor
public class UserDto {
    private String login;
    private String email;

    public UserDto(User u) {
        login = u.getLogin();
        email = u.getEmail();
    }
}
