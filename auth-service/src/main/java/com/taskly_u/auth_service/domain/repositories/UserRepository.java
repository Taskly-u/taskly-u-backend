package com.taskly_u.auth_service.domain.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taskly_u.auth_service.domain.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    Object findByEmail(Object any);

}
