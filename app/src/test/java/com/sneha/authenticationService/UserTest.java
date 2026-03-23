package com.sneha.authenticationService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

class UserTest {
   private IdGenerator idGenerator =mock(IdGenerator.class);
   private TimeUtil timeUtil = mock(TimeUtil.class);

    @Test
    void throwsExceptionWhenUsernameIsNull(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->new User(idGenerator,timeUtil,null, "123"));
    }
    @Test
    void throwsExceptionWhenUsernameIsEmpty(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->new User(idGenerator,timeUtil,"", "123"));
    }

    @Test
    void throwsExceptionWhenPasswordIsNull(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->new User(idGenerator,timeUtil,"sneha", null));
    }

    @Test
    void throwsExceptionWhenPasswordIsEmpty(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->new User(idGenerator,timeUtil,"sneha", ""));
    }

    @Test
    void shouldCreateUser(){
        Assertions.assertDoesNotThrow(()->new User(idGenerator,timeUtil,"sneha","123"));
    }

}