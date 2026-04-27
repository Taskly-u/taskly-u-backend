package com.taskly_u.notification_service.api.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NotificationResponse {
    private UUID id;
    private UUID userId;
    private UUID taskId;
    private String type;
    private String message;
    private boolean isRead;
    private LocalDateTime createdAt;
}
