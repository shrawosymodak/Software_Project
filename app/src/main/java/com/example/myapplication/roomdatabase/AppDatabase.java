package com.example.myapplication.roomdatabase;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.myapplication.Class.User;

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase
{
    public abstract UserDao userDao();
}