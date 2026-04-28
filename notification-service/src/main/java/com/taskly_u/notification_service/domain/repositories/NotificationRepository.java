package com.taskly_u.notification_service.domain.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taskly_u.notification_service.domain.entities.Notification;

public interface NotificationRepository extends JpaRepository<Notification, UUID> {

}
