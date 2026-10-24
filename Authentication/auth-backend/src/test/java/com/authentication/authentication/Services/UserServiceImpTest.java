package com.authentication.authentication.Services;

import com.authentication.authentication.DTOs.UserDTO;
import com.authentication.authentication.Entity.Provider;
import com.authentication.authentication.Entity.User;
import com.authentication.authentication.Repository.UserRepository;
import com.authentication.authentication.Services.Impl.UserServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImpTest {

    @Mock
    private UserRepository userRepository;

    @Spy
    private ModelMapper modelMapper = new ModelMapper();

    @Mock
    private PasswordEncoder passwordEncoder;

    private UserServiceImp userService;

    @BeforeEach
    void setUp() {
        userService = new UserServiceImp(userRepository, modelMapper, passwordEncoder);
    }

    @Test
    void testCreateUser_Success() {
        UserDTO inputDto = UserDTO.builder()
                .email("test@example.com")
                .name("Test User")
                .password("plainPassword")
                .build();

        User savedUser = User.builder()
                .id(UUID.randomUUID())
                .email("test@example.com")
                .name("Test User")
                .password("encodedPassword")
                .provider(Provider.LOCAL)
                .build();

        when(userRepository.existsByEmail("test@example.com")).thenReturn(false);
        when(passwordEncoder.encode("plainPassword")).thenReturn("encodedPassword");
        when(userRepository.save(any(User.class))).thenReturn(savedUser);

        UserDTO result = userService.createUser(inputDto);

        assertNotNull(result);
        assertEquals("test@example.com", result.getEmail());
        assertEquals("Test User", result.getName());
        verify(userRepository).save(any(User.class));
    }

    @Test
    void testCreateUser_BlankEmail_ThrowsException() {
        UserDTO inputDto = UserDTO.builder().email("").build();

        assertThrows(IllegalArgumentException.class, () -> userService.createUser(inputDto));
    }

    @Test
    void testCreateUser_DuplicateEmail_ThrowsException() {
        UserDTO inputDto = UserDTO.builder().email("existing@example.com").build();
        when(userRepository.existsByEmail("existing@example.com")).thenReturn(true);

        assertThrows(IllegalArgumentException.class, () -> userService.createUser(inputDto));
    }

    @Test
    void testGetUserByEmail_Success() {
        User user = User.builder()
                .id(UUID.randomUUID())
                .email("test@example.com")
                .name("Test User")
                .build();

        when(userRepository.findByEmail("test@example.com")).thenReturn(Optional.of(user));

        UserDTO result = userService.getUserByEmail("test@example.com");

        assertNotNull(result);
        assertEquals("test@example.com", result.getEmail());
    }

    @Test
    void testGetUserByEmail_NotFound() {
        when(userRepository.findByEmail("notfound@example.com")).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class, () -> userService.getUserByEmail("notfound@example.com"));
    }

    @Test
    void testGetAllUsers() {
        User user1 = User.builder().id(UUID.randomUUID()).email("user1@example.com").build();
        User user2 = User.builder().id(UUID.randomUUID()).email("user2@example.com").build();

        when(userRepository.findAll()).thenReturn(List.of(user1, user2));

        List<UserDTO> result = userService.getAllUsers();

        assertEquals(2, result.size());
    }
}
