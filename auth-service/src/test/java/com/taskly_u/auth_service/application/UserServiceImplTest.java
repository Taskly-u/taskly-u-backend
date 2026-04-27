package com.taskly_u.auth_service.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import com.taskly_u.auth_service.api.dto.request.CreateUserRequest;
import com.taskly_u.auth_service.api.dto.response.UserResponse;
import com.taskly_u.auth_service.domain.entities.User;
import com.taskly_u.auth_service.domain.repositories.UserRepository;
import com.taskly_u.auth_service.infrastructure.service.UserService;
import com.taskly_u.auth_service.utils.SortType;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void shouldCreateUserSuccessfully() {
        CreateUserRequest request = new CreateUserRequest();
        request.setFullName("Santi");
        request.setEmail("test@test.com");
        request.setPassword("123");
        request.setSemester(5);

        User savedUser = User.builder()
                .id(UUID.randomUUID())
                .fullName("Santi")
                .email("test@test.com")
                .password("123")
                .semester(5)
                .build();

        when(userRepository.save(any(User.class))).thenReturn(savedUser);

        UserResponse response = userService.create(request);

        assertEquals("Santi", response.getFullName());
        assertEquals("test@test.com", response.getEmail());

        verify(userRepository).save(any(User.class));
    }

    @Test
    void shouldReturnUserById() {
        UUID id = UUID.randomUUID();

        User user = User.builder()
                .id(id)
                .fullName("Santi")
                .email("test@test.com")
                .build();

        when(userRepository.findById(id)).thenReturn(Optional.of(user));

        UserResponse response = userService.getById(id);

        assertEquals("Santi", response.getFullName());
    }

    @Test
    void shouldThrowExceptionWhenUserNotFound() {
        UUID id = UUID.randomUUID();

        when(userRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> userService.getById(id));
    }

    @Test
    void shouldUpdateUser() {
        UUID id = UUID.randomUUID();

        User existingUser = User.builder()
                .id(id)
                .fullName("Old Name")
                .email("old@test.com")
                .semester(3)
                .build();

        CreateUserRequest request = new CreateUserRequest();
        request.setFullName("New Name");
        request.setEmail("new@test.com");
        request.setPassword("123");
        request.setSemester(6);

        when(userRepository.findById(id)).thenReturn(Optional.of(existingUser));
        when(userRepository.save(any(User.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        UserResponse response = userService.update(request, id);

        assertEquals("New Name", response.getFullName());
        assertEquals("new@test.com", response.getEmail());
        assertEquals(6, response.getSemester());
    }

    @Test
    void shouldDeleteUser() {
        UUID id = UUID.randomUUID();

        when(userRepository.findById(id)).thenReturn(Optional.of(new User()));

        userService.delete(id);

        verify(userRepository).deleteById(id);
    }

    @Test
    void shouldReturnPaginatedUsers() {
        Page<User> page = new PageImpl<>(List.of(new User()));

        when(userRepository.findAll(any(PageRequest.class))).thenReturn(page);

        Page<UserResponse> response = userService.getAll(0, 10, SortType.NONE);

        assertEquals(1, response.getContent().size());
    }

}