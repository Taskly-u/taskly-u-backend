package com.taskly_u.academic_service.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "semester_sumary")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SemesterSumary {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private int semester;
    private int totalTasks;
    private int completedTasks;
    private int expiredTasks;
    private float progressPercentage;
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

//    Relaciones
    

    @PrePersist
    public void PrePersist(){ this.createdAt=LocalDateTime.now();}
}
