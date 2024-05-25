package com.example.myapplication.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.myapplication.Class.TodoClass;

import java.util.List;
@Dao
public interface TodoDao
{
    @Query("SELECT * FROM todoclass WHERE user_id = :userId")
    List<TodoClass> getAll(int userId);
    @Insert
    void insertAll(TodoClass todo);
    @Delete
    void delete(TodoClass todo);
}
