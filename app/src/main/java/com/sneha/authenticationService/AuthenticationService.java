package com.sneha.authenticationService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class AuthenticationService {
    private IdGenerator idGenerator;
    private Mapper mapper;
    private UserDatabase userDatabase;
    private static final Logger log = LoggerFactory.getLogger(AuthenticationService.class);
    public AuthenticationService(IdGenerator idGenerator, Mapper mapper, UserDatabase userDatabase){
        if(userDatabase ==null){
            log.error("UserData is null");
            throw new IllegalArgumentException("User Database cannot be null");
        }
        if(mapper ==null){
            log.error("Mapper is null");
            throw new IllegalArgumentException("Mapper cannot be null");
        }
        if(idGenerator ==null){
            log.error("Idgenerator is null");
            throw new IllegalArgumentException("Idgenerator cannot be null");
        }
        this.userDatabase=userDatabase;
        this.idGenerator=idGenerator;
        this.mapper=mapper;
    }

   public boolean createUser(String username,String password ) {
      if(userDatabase.userExistsAlready(username, password)) {
          log.debug("User name already exists in database %s ",username);
            return false;
        }
        else {
            User user = mapper.mapCreateUserRequestToUser(username, password);
            log.debug("User created with username %s",username);
            userDatabase.addUser(user);
            log.debug("User added to database with username %s", username);
            return true;
        }
    }

    public  String generateToken(String username, String password){
        if(!userDatabase.userExistsAlready(username,password)){
            log.error("User credentials invalid for token generation");
             throw new IllegalArgumentException("Invalid credentials");
        }

        String id  = idGenerator.generate();
        log.debug("Token generated %s",id);
        userDatabase.updateUser(username, password, id);
        log.debug("Token added to the database for username %s", username);
        return id;

    }

  public   boolean validateToken(String token){
        return userDatabase.validateUserToken(token);
    }
}
