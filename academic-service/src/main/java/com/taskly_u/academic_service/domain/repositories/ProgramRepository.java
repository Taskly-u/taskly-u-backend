package com.taskly_u.academic_service.domain.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taskly_u.academic_service.domain.entities.Program;

@Repository
public interface ProgramRepository extends JpaRepository<Program, UUID> {
}
