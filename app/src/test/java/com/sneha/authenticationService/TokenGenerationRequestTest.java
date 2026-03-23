package com.sneha.authenticationService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TokenGenerationRequestTest {
    @Test
    void throwsExceptionWhenUsernameIsNull(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->new TokenGenerationRequest(null, "123"));
    }
    @Test
    void throwsExceptionWhenUsernameIsEmpty(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->new TokenGenerationRequest("", "123"));
    }

    @Test
    void throwsExceptionWhenPasswordIsNull(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->new TokenGenerationRequest("sneha", null));
    }

    @Test
    void throwsExceptionWhenPasswordIsEmpty(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->new TokenGenerationRequest("sneha", ""));
    }

    @Test
    void shouldCreateUserRequest(){
        Assertions.assertDoesNotThrow(()->new TokenGenerationRequest("sneha","123"));
    }

}