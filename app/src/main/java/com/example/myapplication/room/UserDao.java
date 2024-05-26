package com.example.myapplication.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.myapplication.Class.User;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getAll();
    @Insert
    void insertAll(User users);

    @Delete
    void delete(User user);
//    For the purpose of login
    @Query("SELECT * FROM user WHERE email = :email AND password = :password LIMIT 1")
    User loginuser(String email, String password);
}