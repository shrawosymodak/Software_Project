package com.example.myapplication.Class;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "users")
public class User
    {
        @PrimaryKey(autoGenerate = true)
            public int uid;
            @ColumnInfo(name = "username")
            public String firstName;
        @ColumnInfo(name = "email")
            public String email;
            @ColumnInfo(name = "password")
            public String password;

        public User(String firstName, String email, String password) {
            this.firstName = firstName;
            this.email = email;
            this.password = password;
        }


    }

