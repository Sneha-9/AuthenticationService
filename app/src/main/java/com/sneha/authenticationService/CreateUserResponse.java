package com.sneha.authenticationService;

public class CreateUserResponse {
    private boolean response;
    public CreateUserResponse(boolean response){
        this.response = response;
    }

    public boolean isResponse() {
        return response;
    }
}
