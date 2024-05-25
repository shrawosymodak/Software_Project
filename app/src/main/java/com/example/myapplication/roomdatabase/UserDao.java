package com.example.myapplication.roomdatabase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.myapplication.Class.User;

import java.util.List;

@Dao
public interface UserDao
{

    @Insert
    void insert(User  users);

    @Delete
    void delete(User user);
}
