package com.taskly_u.academic_service.infrastructure.abstract_service;

import java.util.UUID;

import com.taskly_u.academic_service.api.dto.request.SubjectRequest;
import com.taskly_u.academic_service.api.dto.response.SubjectResponse;

public interface ISubjectService extends IDefault<SubjectRequest, SubjectResponse, UUID> {

}
