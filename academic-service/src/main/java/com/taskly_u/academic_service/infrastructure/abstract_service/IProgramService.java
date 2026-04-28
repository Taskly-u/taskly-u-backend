package com.taskly_u.academic_service.infrastructure.abstract_service;

import java.util.UUID;

import com.taskly_u.academic_service.api.dto.request.ProgramRequest;
import com.taskly_u.academic_service.api.dto.response.ProgramResponse;

public interface IProgramService extends IDefault<ProgramRequest, ProgramResponse, UUID> {

}
