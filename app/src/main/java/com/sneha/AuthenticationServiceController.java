package com.sneha;


import com.sneha.authenticationService.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthenticationServiceController {
    private IdGenerator idGenerator = new IdGenerator();
    private TimeUtil timeUtil = new TimeUtil();
    private Mapper mapper = new Mapper(idGenerator, timeUtil);
    private UserDatabase userDatabase= new UserDatabase();
    private AuthenticationService authenticationService = new AuthenticationService(idGenerator,mapper,userDatabase);

    @PostMapping(value = "/com/sneha/authenticationService/user",produces = "application/json")
    public CreateUserResponse createUser( @RequestBody  CreateUserRequest createUserRequest){
       boolean response = authenticationService.createUser(createUserRequest.getUserName(), createUserRequest.getPassword());
       //System.out.println(response);
       return new CreateUserResponse(response);
    }

    @PostMapping(value = "/com/sneha/authenticationService/token",produces = "application/json")
    public TokenGenerationResponse generateToken( @RequestBody  TokenGenerationRequest tokenGenerationRequest){
        String response = authenticationService.generateToken(tokenGenerationRequest.getUserName(), tokenGenerationRequest.getPassword());
        //System.out.println(response);
        return new TokenGenerationResponse(response);
    }

    @GetMapping(value = "/com/sneha/authenticationService/validate-token/{token}",produces = "application/json")
    public TokenValidationResponse validateToken(@PathVariable("token") String token){
        boolean response = authenticationService.validateToken(token);
        return new TokenValidationResponse(response);
    }

}
