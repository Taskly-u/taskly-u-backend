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
public class EmailLogResponse {
    private UUID id;
    private UUID userId;
    private String type;
    private LocalDateTime sentAt;
}
