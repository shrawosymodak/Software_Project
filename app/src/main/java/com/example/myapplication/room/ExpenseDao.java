package com.example.myapplication.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.myapplication.Class.ExpenseClass;

import java.util.List;
@Dao
public interface ExpenseDao
{
    @Query("SELECT * FROM expenseclass")
    List<ExpenseClass> getAll();
    @Insert
    void insertAll(ExpenseClass expense);
    @Delete
    void delete(ExpenseClass expense);
}
