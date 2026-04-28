package com.taskly_u.task_service.domain.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taskly_u.task_service.domain.entities.TaskArchive;

@Repository
public interface TaskArchiveRepository extends JpaRepository<TaskArchive, UUID>{

}
