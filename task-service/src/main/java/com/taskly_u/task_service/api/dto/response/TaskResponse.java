package com.taskly_u.task_service.api.dto.response;

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
public class TaskResponse {
    private UUID id;
    private UUID userId;
    private UUID subjectId;
    private UUID categoryId;
    private String title;
    private String description;
    private String priority;
    private String status;
    private LocalDateTime dueDate;
    private LocalDateTime completedAt;
    private Double grade;
    private Double percentage;
    private boolean isDeleted;
    private LocalDateTime createdAt;
}
