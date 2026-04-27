package com.taskly_u.task_service.infrastructure.service;

import java.util.UUID;

import com.taskly_u.task_service.api.dto.request.CreateTaskRequest;
import com.taskly_u.task_service.api.dto.response.TaskResponse;
import com.taskly_u.task_service.utils.TaskStatus;

public class TaskService {

    public TaskResponse create(CreateTaskRequest request, UUID randomUUID, UUID randomUUID2) {
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    public TaskResponse getById(UUID randomUUID) {
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    public TaskResponse update(UUID randomUUID, CreateTaskRequest request) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    public Object changeStatus(UUID randomUUID, TaskStatus inProgress) {
        throw new UnsupportedOperationException("Unimplemented method 'changeStatus'");
    }

    public void delete(UUID randomUUID) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
