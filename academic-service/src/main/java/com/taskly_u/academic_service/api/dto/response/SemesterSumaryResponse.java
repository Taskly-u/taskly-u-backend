package com.taskly_u.academic_service.api.dto.response;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SemesterSumaryResponse {
    private UUID id;
    private UUID userId;
    private int semester;
    private int totalTasks;
    private int completedTasks;
    private int expiredTasks;
    private double progressPercentage;
}
