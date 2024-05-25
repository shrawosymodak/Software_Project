package com.example.myapplication.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import com.example.myapplication.Class.BalanceClass;

import java.util.List;

@Dao
public interface BalanceDao
{
    @Query("SELECT * FROM balanceclass")
    List<BalanceClass> getAll();
    @Insert
    void insertAll(BalanceClass balance);
    @Delete
    void delete(BalanceClass balance);


}
