package com.taskly_u.task_service.domain.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taskly_u.task_service.domain.entities.TaskCategory;

@Repository
public interface TaskCategoryRepository extends JpaRepository<TaskCategory, UUID>{

}
