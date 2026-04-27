package com.taskly_u.task_service.domain.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taskly_u.task_service.domain.entities.TaskHistory;

@Repository
public interface TaskHistoryRepository extends JpaRepository<TaskHistory, UUID> {

}
