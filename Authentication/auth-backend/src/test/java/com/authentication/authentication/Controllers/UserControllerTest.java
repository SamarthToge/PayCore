package com.authentication.authentication.Controllers;

import com.authentication.authentication.DTOs.UserDTO;
import com.authentication.authentication.Services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    void testCreate() {
        UserDTO inputDto = UserDTO.builder().email("test@example.com").name("Test").build();
        UserDTO savedDto = UserDTO.builder().id(UUID.randomUUID()).email("test@example.com").name("Test").build();

        when(userService.createUser(inputDto)).thenReturn(savedDto);

        ResponseEntity<UserDTO> response = userController.create(inputDto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("test@example.com", response.getBody().getEmail());
    }

    @Test
    void testGetAllUsers() {
        UserDTO user1 = UserDTO.builder().email("user1@example.com").build();
        when(userService.getAllUsers()).thenReturn(List.of(user1));

        ResponseEntity<List<UserDTO>> response = userController.getAllUsers();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
    }

    @Test
    void testGetUserByEmail() {
        UserDTO user = UserDTO.builder().email("user@example.com").build();
        when(userService.getUserByEmail("user@example.com")).thenReturn(user);

        ResponseEntity<UserDTO> response = userController.getUserByEmail("user@example.com");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("user@example.com", response.getBody().getEmail());
    }

    @Test
    void testUpdateUser() {
        UserDTO updateDto = UserDTO.builder().name("Updated Name").build();
        String userId = UUID.randomUUID().toString();
        when(userService.updateUser(updateDto, userId)).thenReturn(updateDto);

        ResponseEntity<UserDTO> response = userController.updateUser(updateDto, userId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Updated Name", response.getBody().getName());
    }
}
