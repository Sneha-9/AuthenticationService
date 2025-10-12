package com.sneha.authenticationService;

public class AuthenticationService {
    private IdGenerator idGenerator;
    private Mapper mapper;
    private UserDatabase userDatabase;

    public AuthenticationService(IdGenerator idGenerator, Mapper mapper, UserDatabase userDatabase){
        this.userDatabase=userDatabase;
        this.idGenerator=idGenerator;
        this.mapper=mapper;
    }

   public boolean createUser(String username,String password ) {
       // System.out.print(username + " "+password);
        if(userDatabase.userExistsAlready(username, password)) {
            return false;
        }
        else {
            User user = mapper.mapCreateUserRequestToUser(username, password);
            userDatabase.addUser(user);
            return true;
        }
    }

    public  String generateToken(String username, String password){
        if(!userDatabase.userExistsAlready(username,password)){
             throw new IllegalArgumentException("Invalid credentials");
        }



        String id  = idGenerator.generate();
        System.out.println(id);
        userDatabase.updateUser(username, password, id);
        return id;

    }

  public   boolean validateToken(String token){
        return userDatabase.validateUserToken(token);
    }
}
