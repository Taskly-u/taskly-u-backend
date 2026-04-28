package com.taskly_u.academic_service.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.taskly_u.academic_service.api.dto.request.ProgramRequest;
import com.taskly_u.academic_service.api.dto.response.ProgramResponse;
import com.taskly_u.academic_service.domain.entities.Program;
import com.taskly_u.academic_service.domain.repositories.SubjectRepository;
import com.taskly_u.academic_service.domain.repositories.ProgramRepository;
import com.taskly_u.academic_service.infrastructure.service.ProgramService;

@ExtendWith(MockitoExtension.class)
class AcademicServiceImplTest {

    @Mock
    private ProgramRepository programRepository;

    @Mock
    private SubjectRepository subjectRepository;

    @InjectMocks
    private ProgramService programService;


    @Test
    void shouldCreateProgram() {
        String programName = "Engineering";

        when(programRepository.save(argThat(program -> program.getName().equals(programName))))
                .thenAnswer(invocation -> invocation.getArgument(0));
        ProgramRequest request = new ProgramRequest(programName);
        ProgramResponse result = programService.create(request);

        assertNotNull(result);
        assertEquals(programName, result.getName());
        assertNotNull(result.getId());

        verify(programRepository).save(any(Program.class));
    }

}
