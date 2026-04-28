package com.taskly_u.auth_service.api.dto.response;

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
public class UserResponse {
    private UUID id;
    private String fullName;
    private String email;
    private UUID programId;
    private int semester;
    private boolean isVerified;
    private boolean isBlocked;
    private int failedAttempts;
    private LocalDateTime createdAt;
}
