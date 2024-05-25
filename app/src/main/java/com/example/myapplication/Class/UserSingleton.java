package com.example.myapplication.Class;

public class UserSingleton {
    private static UserSingleton instance;
    private User user;

    private UserSingleton() {}

    public static synchronized UserSingleton getInstance() {
        if (instance == null) {
            instance = new UserSingleton();
        }
        return instance;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
