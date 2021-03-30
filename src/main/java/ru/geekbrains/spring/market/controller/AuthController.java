package ru.geekbrains.spring.market.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.spring.market.configs.jwt.JwtProvider;
import ru.geekbrains.spring.market.model.dtos.AuthRequestDto;
import ru.geekbrains.spring.market.model.dtos.AuthResponseDto;
import ru.geekbrains.spring.market.model.dtos.SignUpRequestDto;
import ru.geekbrains.spring.market.model.entities.User;
import ru.geekbrains.spring.market.services.UserService;


@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("/register")
    public String registerUser(@RequestBody SignUpRequestDto signUpRequest) {
        User user = new User();
        user.setPassword(signUpRequest.getPassword());
        user.setLogin(signUpRequest.getLogin());
        userService.saveUser(user);
        return "OK";
    }

    @PostMapping("/auth")
    public AuthResponseDto auth(@RequestBody AuthRequestDto request) {
        User user = userService.findByLoginAndPassword(request.getLogin(), request.getPassword());
        String token = jwtProvider.generateToken(user.getLogin());
        return new AuthResponseDto(token);
    }
}