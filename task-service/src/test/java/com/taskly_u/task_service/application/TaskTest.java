package com.taskly_u.task_service.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.taskly_u.task_service.domain.entities.Task;

class TaskTest {

    @Test
    void shouldChangeStatusCorrectly() {
        Task task = new Task();
        task.setStatus("PENDING");

        task.changeStatus("IN_PROGRESS");

        assertEquals("IN_PROGRESS", task.getStatus());
    }

    @Test
    void shouldNotAllowInvalidTransition() {
        Task task = new Task();
        task.setStatus("COMPLETED");

        assertThrows(RuntimeException.class, () -> task.changeStatus("IN_PROGRESS"));
    }

    @Test
    void shouldMarkAsCompleted() {
        Task task = new Task();
        task.setStatus("IN_PROGRESS");

        task.markAsCompleted();

        assertEquals("COMPLETED", task.getStatus());
        assertNotNull(task.getCompletedAt());
    }

    @Test
    void shouldSoftDelete() {
        Task task = new Task();

        task.delete();

        assertTrue(task.isDeleted());
    }

    @Test
    void shouldNotCompleteAlreadyCompletedTask() {
        Task task = new Task();
        task.setStatus("COMPLETED");

        assertThrows(RuntimeException.class,
                task::markAsCompleted);
    }
}