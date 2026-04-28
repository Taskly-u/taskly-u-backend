package com.taskly_u.academic_service.api.dto.request;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectRequest {
    private String name;
    private UUID programId;
    private int semester;
}
