package com.sneha;

import com.sneha.authenticationService.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Time;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AuthenticationServiceControllerTest {
    private IdGenerator idGenerator = mock(IdGenerator.class);
    private TimeUtil timeUtil = mock(TimeUtil.class);
    private Mapper mapper = mock(Mapper.class);
    private UserDatabase userDatabase = mock(UserDatabase.class);
    private AuthenticationService authenticationService = mock(AuthenticationService.class);

    @Test
    void shouldCreateUser(){
        CreateUserRequest createUserRequest = mock(CreateUserRequest.class);
        CreateUserResponse createUserResponse = mock(CreateUserResponse.class);
        when(createUserRequest.getUserName()).thenReturn("sneha");
        when(createUserRequest.getPassword()).thenReturn("123");
        when(authenticationService.createUser(createUserRequest.getUserName(),createUserRequest.getPassword())).thenReturn(true);
        when(createUserResponse.isResponse()).thenReturn(true);

        Assertions.assertDoesNotThrow(()-> new AuthenticationServiceController().createUser(createUserRequest).isResponse());
    }


}