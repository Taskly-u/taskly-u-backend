package com.taskly_u.academic_service.infrastructure.service;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.taskly_u.academic_service.api.dto.request.SubjectRequest;
import com.taskly_u.academic_service.api.dto.response.SubjectResponse;
import com.taskly_u.academic_service.infrastructure.abstract_service.ISubjectService;
import com.taskly_u.academic_service.utils.SortType;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SubjectService implements ISubjectService {

    @Override
    public SubjectResponse create(SubjectRequest request) {
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public SubjectResponse getById(UUID id) {
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public SubjectResponse update(SubjectRequest request, UUID id) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(UUID id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Page<SubjectResponse> getAll(int page, int size, SortType sort) {
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }
    
}
