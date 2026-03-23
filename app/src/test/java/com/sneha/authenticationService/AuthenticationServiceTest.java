package com.sneha.authenticationService;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AuthenticationServiceTest {
  private IdGenerator idGenerator = mock(IdGenerator.class);
  private Mapper mapper  = mock(Mapper.class);
  private UserDatabase userDatabase= mock(UserDatabase.class);

  @AfterEach
  void resetMocks() {

    reset(idGenerator);
    reset(userDatabase);
  }

  @Test
    void shouldCreateUser(){
    when(userDatabase.userExistsAlready("sneha","123")).thenReturn(false);
    Assertions.assertEquals(true, new AuthenticationService(idGenerator,mapper,userDatabase).createUser("sneha","123"));

  }

  @Test
  void shouldReturnFalseForUserAlreadyExists(){
    when(userDatabase.userExistsAlready("sneha","123")).thenReturn(true);
    Assertions.assertEquals(false,new AuthenticationService(idGenerator,mapper,userDatabase).createUser("sneha","123"));
  }

  @Test
  void shouldGenerateToken(){
    when(idGenerator.generate()).thenReturn("123");
    when(userDatabase.userExistsAlready("sneha","1234")).thenReturn(true);
    doNothing().when(userDatabase).updateUser("sneha","1234","");
    Assertions.assertEquals("123",new AuthenticationService(idGenerator,mapper,userDatabase).generateToken("sneha","1234"));
  }

  @Test
  void throwsExceptionWhenInvalidCredentialsPassedToGenerateToken(){
    when(idGenerator.generate()).thenReturn("123");
    when(userDatabase.userExistsAlready("sneha","1234")).thenReturn(false);
    Assertions.assertThrows(IllegalArgumentException.class,()->new AuthenticationService(idGenerator,mapper,userDatabase).generateToken("sneha","1234"));

  }

  @Test
  void validateTokenReturnTrue(){
    when(userDatabase.validateUserToken("123")).thenReturn(true);
    Assertions.assertEquals(true,new AuthenticationService(idGenerator,mapper,userDatabase).validateToken("123"));
  }

}