package com.taskly_u.auth_service.application;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.taskly_u.auth_service.domain.entities.User;
import com.taskly_u.auth_service.domain.repositories.UserRepository;
import com.taskly_u.auth_service.infrastructure.service.AuthService;

@ExtendWith(MockitoExtension.class)
class AuthServiceImplTest {

    @Mock
    private UserRepository repository;

    @InjectMocks
    private AuthService service;

    @Test
    void shouldNotLoginBlockedUser() {
        User user = new User();
        user.setBlocked(true);

        when(repository.findByEmail(any())).thenReturn(Optional.of(user));

        assertThrows(RuntimeException.class,
                () -> service.login("test@test.com", "123"));
    }

    @Test
    void shouldFailWhenUserNotFound() {
        when(repository.findByEmail(any())).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class,
                () -> service.login("test@test.com", "123"));
    }

}
