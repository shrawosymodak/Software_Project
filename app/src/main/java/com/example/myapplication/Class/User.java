package com.example.myapplication.Class;

public class User {
    private int id;
    private String username;
    private String email;
    private String password;


    // Constructor, getters, and setters
    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }

}
