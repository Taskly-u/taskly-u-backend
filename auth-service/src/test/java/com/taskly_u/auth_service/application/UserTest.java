package com.taskly_u.auth_service.application;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.taskly_u.auth_service.domain.entities.User;

class UserTest {

    @Test
    void shouldIncreaseFailedAttempts() {
        User user = new User();
        user.setFailedAttempts(0);

        user.getFailedAttempts();

        assertEquals(1, user.getFailedAttempts());
    }

    @Test
    void shouldBlockUserAfterMaxAttempts() {
        User user = new User();
        user.setFailedAttempts(4);

        user.getFailedAttempts();

        assertTrue(user.isBlocked());
    }

    
@Test
void shouldMarkUserAsVerifiedWhenVerifyIsCalled() {
    // Arrange
    User user = new User();
    assertFalse(user.isVerified(), "El usuario no debe ser verificado inicialmente");

    user.isVerified();

    assertTrue(user.isVerified(), "El usuario debe ser verificado después de llamar a verify().");
}

}
