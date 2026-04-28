package com.taskly_u.academic_service.domain.repositories;

import java.util.UUID;
import com.taskly_u.academic_service.domain.entities.SemesterSumary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SemesterSumaryRepository extends JpaRepository<SemesterSumary, UUID> {
}
