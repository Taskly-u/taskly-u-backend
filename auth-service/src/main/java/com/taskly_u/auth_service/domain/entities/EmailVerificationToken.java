package com.taskly_u.auth_service.domain.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "email")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmailVerificationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
     @Column(nullable = false, unique = true)
    private String token;
     @Column(nullable = false)
    private LocalDateTime expires_at;
     @Column(nullable = false)
    private boolean used;
    
    //Relación
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}

// -- Microservicio: auth-service
// email_verification_tokens (
//     id UUID PRIMARY KEY,
//     user_id UUID NOT NULL,
//     token VARCHAR(255) NOT NULL,
//     expires_at TIMESTAMP NOT NULL,
//     used BOOLEAN DEFAULT FALSE
// );

// -- Relaciones:
// -- email_verification_tokens.user_id → users.id
// 🔹 Tabla: password_reset_tokens
// -- Microservicio: auth-service
// 