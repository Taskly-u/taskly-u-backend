package com.taskly_u.task_service.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.taskly_u.task_service.api.dto.request.CreateTaskRequest;
import com.taskly_u.task_service.api.dto.response.TaskResponse;
import com.taskly_u.task_service.domain.entities.Task;
import com.taskly_u.task_service.domain.repositories.TaskHistoryRepository;
import com.taskly_u.task_service.domain.repositories.TaskRepository;
import com.taskly_u.task_service.infrastructure.service.TaskService;
import com.taskly_u.task_service.utils.TaskStatus;

@ExtendWith(MockitoExtension.class)
class TaskServiceImplTest {

    @Mock
    private TaskRepository taskRepository;

    @Mock
    private TaskHistoryRepository taskHistoryRepository;

    @InjectMocks
    private TaskService taskService;

    @Test
    void shouldCreateTask() {
        CreateTaskRequest request = new CreateTaskRequest(null, null, "Title", "Desc", "HIGH", null);

        when(taskRepository.save(any()))
                .thenAnswer(i -> i.getArgument(0));

        TaskResponse response = taskService.create(request, UUID.randomUUID(), UUID.randomUUID());

        assertEquals("PENDING", response.getStatus());
    }

    @Test
    void shouldGetTaskById() {
        Task task = new Task();

        when(taskRepository.findById(any()))
                .thenReturn(Optional.of(task));

        TaskResponse response = taskService.getById(UUID.randomUUID());

        assertNotNull(response);
    }

    @Test
    void shouldUpdateTask() {
        Task task = new Task();
        task.setTitle("Old");

        when(taskRepository.findById(any())).thenReturn(Optional.of(task));

        CreateTaskRequest request = new CreateTaskRequest(null, null, "New", "Desc", "HIGH", null);

        TaskResponse response = taskService.update(UUID.randomUUID(), request);

        assertEquals("New", response.getTitle());
    }


    @Test
    void shouldChangeStatusToCompleted() {
        Task task = new Task();
        task.setStatus(TaskStatus.IN_PROGRESS);

        when(taskRepository.findById(any())).thenReturn(Optional.of(task));

        taskService.changeStatus(UUID.randomUUID(), TaskStatus.COMPLETED);

        assertEquals(TaskStatus.COMPLETED, task.getStatus());
        verify(taskHistoryRepository).save(any());
    }

    @Test
    void shouldFailInvalidTransition() {
        Task task = new Task();
        task.setStatus(TaskStatus.COMPLETED);

        when(taskRepository.findById(any())).thenReturn(Optional.of(task));

        assertThrows(RuntimeException.class,
                () -> taskService.changeStatus(UUID.randomUUID(), TaskStatus.IN_PROGRESS));
    }

    @Test
    void shouldSoftDeleteTask() {
        Task task = new Task();

        when(taskRepository.findById(any())).thenReturn(Optional.of(task));

        taskService.delete(UUID.randomUUID());

        assertTrue(task.isDeleted());
    }

    @Test
    void shouldNotDeleteAlreadyDeletedTask() {
        Task task = new Task();
        task.setDeleted(true);

        when(taskRepository.findById(any())).thenReturn(Optional.of(task));

        assertThrows(RuntimeException.class,
                () -> taskService.delete(UUID.randomUUID()));
    }

    @Test
    void shouldFailWhenTaskNotFound() {
        when(taskRepository.findById(any())).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class,
                () -> taskService.getById(UUID.randomUUID()));
    }

}
