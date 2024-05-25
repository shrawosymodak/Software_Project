package com.example.myapplication.Class;

import androidx.room.Embedded;
import androidx.room.Relation;

public class UserAndBalance
{
    @Embedded public User user;
    @Relation(
            parentColumn = "uid",
            entityColumn = "user_id"
    )
    public BalanceClass balanceClass;
}
