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
public class SubjectResponse {
    private UUID id;
    private String name;
    private UUID programId;
    private int semester;
}
