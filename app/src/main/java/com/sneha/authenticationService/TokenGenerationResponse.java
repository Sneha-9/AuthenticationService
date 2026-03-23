package com.sneha.authenticationService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TokenGenerationResponse {
    private String id ;
    private static final Logger log = LoggerFactory.getLogger(AuthenticationService.class);

    public TokenGenerationResponse(String id){
        if(id == null || id.isEmpty()){
            log.error("Id is null or empty");
            throw new IllegalArgumentException("Id cannot be null or empty");
        }
        this.id=id;
    }

    public String getId() {
        return id;
    }
}
