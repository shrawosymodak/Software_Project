package com.example.myapplication.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.myapplication.Class.BalanceClass;

import java.util.List;

@Dao
public interface BalanceDao
{
    @Query("SELECT * FROM balanceclass WHERE user_id = :userId")
    List<BalanceClass> getAll(int userId);
    @Insert
    void insertAll(BalanceClass balance);
    @Update
    void update(BalanceClass balance);
    @Delete
    void delete(BalanceClass balance);


}
