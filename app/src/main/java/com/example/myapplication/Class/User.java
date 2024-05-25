package com.example.myapplication.Class;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
@Entity
public class User
{
    @PrimaryKey
    public int uid;

    @ColumnInfo(name = "name")
    public String firstName;

    @ColumnInfo(name = "email")
    public String lastName;
    @ColumnInfo(name = "password")
    public String password;

    public User() {
    }



    public User(int uid, String firstName, String lastName, String password) {
        this.uid = uid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }



    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUid() {
        return uid;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }
}

