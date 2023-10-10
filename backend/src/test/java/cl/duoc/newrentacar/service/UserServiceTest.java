package cl.duoc.newrentacar.service;

import cl.duoc.newrentacar.repository.UserRepository;
import cl.duoc.newrentacar.repository.model.UserEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;


    @Test
    void testLoginSuccess() {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail("test@example.com");
        userEntity.setPassword("password123");

        when(userRepository.findByEmail("test@example.com")).thenReturn(Optional.of(userEntity));

        boolean result = userService.login("test@example.com", "password123");

        assertTrue(result);
        verify(userRepository, times(1)).findByEmail("test@example.com");
    }

    @Test
    void testLoginWrongPassword() {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail("test@example.com");
        userEntity.setPassword("password123");

        when(userRepository.findByEmail("test@example.com")).thenReturn(Optional.of(userEntity));

        boolean result = userService.login("test@example.com", "wrongPassword");

        assertFalse(result);
        verify(userRepository, times(1)).findByEmail("test@example.com");
    }

    @Test
    void testLoginUserNotFound() {
        when(userRepository.findByEmail("test@example.com")).thenReturn(Optional.empty());

        boolean result = userService.login("test@example.com", "password123");

        assertFalse(result);
        verify(userRepository, times(1)).findByEmail("test@example.com");
    }

}