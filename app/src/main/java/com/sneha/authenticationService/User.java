package com.sneha.authenticationService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class User {
    private String name;
    private String password;
    private long createdAt;
    private long updatedAt;
    private String  id;
    private static final Logger log = LoggerFactory.getLogger(AuthenticationService.class);

    User(IdGenerator idGenerator, TimeUtil timeUtil,String name, String password){
        if(name  == null || name.isEmpty()){
            log.error("Username is null or empty");
            throw  new IllegalArgumentException("Name cannot be null or empty");
        }
        if(password  == null || password.isEmpty()){
            log.error("Password is null or empty");
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
        this.name = name;
        this.password = password;
        this.createdAt= timeUtil.getCurrentTime();
        this.updatedAt= timeUtil.getCurrentTime();
        this.id= idGenerator.generate();
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }



    public String getId() {
        return id;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }
}
