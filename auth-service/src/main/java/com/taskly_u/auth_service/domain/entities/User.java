package com.taskly_u.auth_service.domain.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "users")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100)
    @Column(nullable = false)
    private String fullName;
    @Email(message = "Correo inválido")
    @Column(unique = true, nullable = false)
    private String email;
    @NotBlank
    @Size(min = 12, message = "La contraseña debe tener mínimo 12 caracteres")
    @Column(nullable = false)
    private String password;
    @Min(1)
    @Max(10)
    @Column(nullable = false)
    private int semester;
    @Column(nullable = false)
    private boolean verified;
    @Column(nullable = false)
    private boolean blocked;
    @Column(nullable = false)
    private int failedAttempts;
    @Column(nullable = false)
    private LocalDateTime blockUtil;
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    public void PrePersist() {
        this.createdAt = LocalDateTime.now();
    }

}

// users (
// id,
// full_name,
// email,
// password,
// program_id, -- ⚠️ solo referencia, no FK real
// semester,
// is_verified,
// is_blocked,
// failed_attempts,
// block_until,
// created_at
// )