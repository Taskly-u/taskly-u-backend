package com.taskly_u.academic_service.infrastructure.service;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.taskly_u.academic_service.api.dto.request.ProgramRequest;
import com.taskly_u.academic_service.api.dto.response.ProgramResponse;
import com.taskly_u.academic_service.infrastructure.abstract_service.IProgramService;
import com.taskly_u.academic_service.utils.SortType;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProgramService implements IProgramService {

    @Override
    public ProgramResponse create(ProgramRequest request) {
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public ProgramResponse getById(UUID id) {
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public ProgramResponse update(ProgramRequest request, UUID id) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(UUID id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Page<ProgramResponse> getAll(int page, int size, SortType sort) {
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

}
