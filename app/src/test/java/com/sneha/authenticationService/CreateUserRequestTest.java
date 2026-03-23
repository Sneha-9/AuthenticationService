package com.sneha.authenticationService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateUserRequestTest {

    @Test
    void throwsExceptionWhenUsernameIsNull(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->new CreateUserRequest(null, "123"));
    }
    @Test
    void throwsExceptionWhenUsernameIsEmpty(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->new CreateUserRequest("", "123"));
    }

    @Test
    void throwsExceptionWhenPasswordIsNull(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->new CreateUserRequest("sneha", null));
    }

    @Test
    void throwsExceptionWhenPasswordIsEmpty(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->new CreateUserRequest("sneha", ""));
    }

    @Test
    void shouldCreateUserRequest(){
        Assertions.assertDoesNotThrow(()->new CreateUserRequest("sneha","123"));
    }
}