package com.taskly_u.task_service.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChangeTaskStatusRequest {
    private String status; // PENDING, IN_PROGRESS, COMPLETED, EXPIRED
}
