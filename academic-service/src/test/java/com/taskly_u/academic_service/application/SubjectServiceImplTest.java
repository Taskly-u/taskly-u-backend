package com.taskly_u.academic_service.application;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.UUID;

import com.taskly_u.academic_service.api.dto.request.SubjectRequest;
import com.taskly_u.academic_service.api.dto.response.SubjectResponse;
import com.taskly_u.academic_service.domain.entities.Subject;
import com.taskly_u.academic_service.domain.repositories.SubjectRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.taskly_u.academic_service.infrastructure.service.SubjectService;

@ExtendWith(MockitoExtension.class)
class SubjectServiceImplTest {

    @Mock
    private SubjectRepository subjectRepository;

    @InjectMocks
    private SubjectService subjectService;

    @Test
    void shouldCreateSubject() {
        Subject subject = new Subject();

        when(subjectRepository.save(any())).thenReturn(subject);

        SubjectRequest request = new SubjectRequest("Math", UUID.randomUUID(), 1);

        SubjectResponse result = subjectService.create(request);

        assertNotNull(result);
    }

}
