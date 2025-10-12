package com.sneha.authenticationService;

public class TokenGenerationResponse {
    private String id ;
    public TokenGenerationResponse(String id){
        this.id=id;
    }

    public String getId() {
        return id;
    }
}
