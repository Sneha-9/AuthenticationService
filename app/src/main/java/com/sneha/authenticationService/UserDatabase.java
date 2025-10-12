package com.sneha.authenticationService;

import java.sql.*;

public class UserDatabase {

    private Connection connection;
    public UserDatabase(){
        String jdbcURL = "jdbc:postgresql://localhost:5432/authenticationservice";
        String username = "sneha";
        String password = "password";

        // Establish the connection
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(jdbcURL, username, password);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    void addUser(User user){
     String addStatement = String.format("Insert into users (name, password,id,createdat, updatedat) values ('%s','%s', '%s','%d','%d')",
             user.getName(),
             user.getPassword(),
             user.getId(),
             user.getCreatedAt(),
             user.getUpdatedAt());

        try {
            Statement statement = connection.createStatement();
            statement.execute(addStatement);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    void updateUser(String username, String password, String token){
        String updateStatement = String.format("Update users SET token = '%s' where name = '%s' and password = '%s'",token,
                username,
                password);
        try {
            Statement statement = connection.createStatement();
            statement.execute(updateStatement);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    boolean userExistsAlready(String username, String password){
        String queryStatement = String.format("Select * from users where name = '%s' and password = '%s'",
               username,
                password);
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(queryStatement);
            if(resultSet.next()){
                return true;
            }
            else return false;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    boolean validateUserToken(String token){
        String queryStatement = String.format("Select * from users where token = '%s'",token);
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(queryStatement);
            if(resultSet.next()){
                return true;
            }
            else return false;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




}
