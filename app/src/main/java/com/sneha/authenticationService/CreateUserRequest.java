package com.sneha.authenticationService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateUserRequest {
    private String username;
    private String password;
    private static final Logger log = LoggerFactory.getLogger(AuthenticationService.class);

    CreateUserRequest(String username, String password){
        if(username == null || username.isEmpty()){
            log.error("Username is null or empty: %s",username);
            throw new IllegalArgumentException("Username cannot be empty or null");
        }
        if(password == null || password.isEmpty()){
            log.error("Password is null or empty: %s",password);
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
        this.username =username;
        this.password=password;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return username;
    }
}
