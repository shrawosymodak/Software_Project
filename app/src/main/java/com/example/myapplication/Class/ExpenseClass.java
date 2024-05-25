package com.example.myapplication.Class;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(primaryKeys = {"id","user_id"})
public class ExpenseClass
{

    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "user_id")
    public int user_id;
    @ColumnInfo(name = "amount")
    int amount;
    @ColumnInfo (name = "description")
    String Description;
    @ColumnInfo (name = "type")
    String type;

    public ExpenseClass(int amount, String description, String type, int id , int user_id)
    {
        this.amount = amount;
        Description = description;
        this.type = type;
        this.id=id;
        this.user_id=user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ExpenseClass()
    {

    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
