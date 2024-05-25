package com.example.myapplication.Class;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(primaryKeys = {"id","user_id"})
public class TodoClass
{
    @ColumnInfo(name = "id")
    private int id;
    @ColumnInfo(name = "user_id")
    private int user_id;
    @ColumnInfo(name = "task")
    private String task;
    @ColumnInfo(name = "status")
    private int status;
;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public TodoClass()
    {

    }
    public TodoClass(String task, int status , int id, int uid)
    {
        this.task = task;
        this.status = status;
        this.id = id;
        this.user_id = uid ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}




