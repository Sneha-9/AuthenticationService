package com.sneha.authenticationService;

public class CreateUserRequest {
    private String userName;
    private String password;
    //private String emailId;

    CreateUserRequest(String userName, String password){
        //this.emailId=emailId;
        this.userName =userName;
        this.password=password;
    }

    public String getPassword() {
        return password;
    }

//    public String getEmailId() {
//        return emailId;
//    }

    public String getUserName() {
        return userName;
    }
}
