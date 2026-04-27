package com.taskly_u.notification_service.application;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.taskly_u.notification_service.domain.repositories.EmailLogRepository;
import com.taskly_u.notification_service.infrastructure.service.EmailService;

@ExtendWith(MockitoExtension.class)
class EmailLogServiceImplTest {

    @Mock
    private EmailLogRepository repository;

    @InjectMocks
    private EmailService service;

    @Test
    void shouldLogEmail() {
        service.logEmail(UUID.randomUUID(), "RESET");

        verify(repository).save(any());
    }

}
