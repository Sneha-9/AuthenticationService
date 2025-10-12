package com.sneha.authenticationService;

public class TokenGenerationRequest {
    private String userName;
    private String password;


    TokenGenerationRequest(String userName, String password){
        this.password=password;
        this.userName=userName;

    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }


}
