package com.taskly_u.notification_service.application;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.taskly_u.notification_service.domain.entities.Notification;
import com.taskly_u.notification_service.domain.repositories.NotificationRepository;
import com.taskly_u.notification_service.infrastructure.service.NotificationService;

@ExtendWith(MockitoExtension.class)
class NotificationServiceImplTest {

    @Mock
    private NotificationRepository notificationRepository;

    @InjectMocks
    private NotificationService service;

    @Test
    void shouldSendNotification() {
        service.send(UUID.randomUUID(), "TASK", "Mensaje");

        verify(notificationRepository).save(any());
    }

    @Test
    void shouldMarkAsRead() {
        Notification n = new Notification();
        n.setRead(false);

        when(notificationRepository.findById(any()))
                .thenReturn(Optional.of(n));

        service.markAsRead(UUID.randomUUID());

        assertTrue(n.isRead());
    }

}