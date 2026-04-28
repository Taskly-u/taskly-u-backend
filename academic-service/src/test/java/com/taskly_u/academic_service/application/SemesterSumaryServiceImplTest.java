package com.taskly_u.academic_service.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.taskly_u.academic_service.domain.entities.SemesterSumary;
import com.taskly_u.academic_service.domain.repositories.SemesterSumaryRepository;
import com.taskly_u.academic_service.infrastructure.service.SemesterSumaryService;

@ExtendWith(MockitoExtension.class)
class SemesterSumaryServiceImplTest {

    @Mock
    private SemesterSumaryRepository repository;

    @InjectMocks
    private SemesterSumaryService service;

    @Test
    void shouldCalculateSummary() {
        SemesterSumary summary = service.calculateSummary(
                UUID.randomUUID(), 5, 10, 7, 1);

        assertEquals(70.0, summary.getProgressPercentage());
    }
}
