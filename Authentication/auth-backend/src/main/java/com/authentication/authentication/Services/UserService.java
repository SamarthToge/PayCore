package com.authentication.authentication.Services;

import com.authentication.authentication.DTOs.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);
    UserDTO getUserByEmail(String email);
    UserDTO updateUser(UserDTO userDTO, String userId);
    void deleteUser(String userId);
    UserDTO getUserById(String userId);
    List<UserDTO> getAllUsers();
}