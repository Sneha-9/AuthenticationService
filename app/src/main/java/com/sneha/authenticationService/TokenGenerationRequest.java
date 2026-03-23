package com.sneha.authenticationService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TokenGenerationRequest {
    private String username;
    private String password;
    private static final Logger log = LoggerFactory.getLogger(AuthenticationService.class);


    TokenGenerationRequest(String username, String password){
        if(username == null || username.isEmpty()){
            log.error("username is null or empty: %s", username);
            throw new IllegalArgumentException("Username cannot be empty or null");
        }
        if(password == null || password.isEmpty()){
            log.error("password is null or empty: %s",password);
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
        this.password=password;
        this.username=username;

    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return username;
    }


}
