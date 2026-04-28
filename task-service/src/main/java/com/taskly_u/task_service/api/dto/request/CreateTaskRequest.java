package com.taskly_u.task_service.api.dto.request;

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
public class CreateTaskRequest {
    private UUID subjectId;
    private UUID categoryId;
    private String title;
    private String description;
    private String priority; // LOW, MEDIUM, HIGH
    private LocalDateTime dueDate;
}
