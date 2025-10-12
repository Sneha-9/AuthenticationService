package com.sneha.authenticationService;

public class TokenValidationResponse {
    private boolean response;
    public TokenValidationResponse(boolean response){
        this.response = response;
    }

    public boolean isResponse() {
        return response;
    }
}
