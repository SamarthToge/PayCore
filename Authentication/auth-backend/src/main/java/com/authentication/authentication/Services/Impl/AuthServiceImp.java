package com.authentication.authentication.Services.Impl;

import com.authentication.authentication.DTOs.UserDTO;
import com.authentication.authentication.Services.AuthService;
import com.authentication.authentication.Services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImp implements AuthService {

    private final UserService userService;

    @Override
    public UserDTO regUser(UserDTO userDTO){
        return userService.createUser(userDTO);
    }
}