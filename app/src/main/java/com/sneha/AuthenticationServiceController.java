package com.sneha;


import com.sneha.authenticationService.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthenticationServiceController {
    private IdGenerator idGenerator = new IdGenerator();
    private TimeUtil timeUtil = new TimeUtil();
    private Mapper mapper = new Mapper(idGenerator, timeUtil);
    private UserDatabase userDatabase= new UserDatabase();
    private AuthenticationService authenticationService = new AuthenticationService(idGenerator,mapper,userDatabase);
    private static final Logger log = LoggerFactory.getLogger(AuthenticationService.class);

    @PostMapping(value = "/com/sneha/authenticationService/user",produces = "application/json")
    public CreateUserResponse createUser( @RequestBody  CreateUserRequest createUserRequest){
        log.info("Create user flow started");
        if(createUserRequest == null){
            log.error("Username or Password is null");
            throw  new IllegalArgumentException("Username or Password cannot be null");
        }
       boolean response = authenticationService.createUser(createUserRequest.getUserName(), createUserRequest.getPassword());
        log.info("Create user flow ended");
       return new CreateUserResponse(response);
    }

    @PostMapping(value = "/com/sneha/authenticationService/token",produces = "application/json")
    public TokenGenerationResponse generateToken( @RequestBody  TokenGenerationRequest tokenGenerationRequest){
        log.info("Generate token flow started");
        if(tokenGenerationRequest == null){
            log.error("Username or Password is null");
            throw  new IllegalArgumentException("Username or Password cannot be null");
        }
        String response = authenticationService.generateToken(tokenGenerationRequest.getUserName(), tokenGenerationRequest.getPassword());
        log.info("Generate token flow ended");
        return new TokenGenerationResponse(response);
    }

    @GetMapping(value = "/com/sneha/authenticationService/validate-token/{token}",produces = "application/json")
    public TokenValidationResponse validateToken(@PathVariable("token") String token){
        log.info("Validate token flow started");
        if(token == null || token.isEmpty()){
            log.error("Token is null or empty");
            throw new IllegalArgumentException("Token cannot be null or empty");
        }
        boolean response = authenticationService.validateToken(token);
        log.info("Validate token flow ended");
        return new TokenValidationResponse(response);
    }

}
