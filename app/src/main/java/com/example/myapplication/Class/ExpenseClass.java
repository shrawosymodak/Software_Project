package com.example.myapplication.Class;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class ExpenseClass
{


    @PrimaryKey(autoGenerate = true)
    public int id;
    public int uid;
    @ColumnInfo(name = "amount")
    int amount;
    @ColumnInfo (name = "description")
    String Description;
    @ColumnInfo (name = "type")
    String type;

    public ExpenseClass(int amount, String description, String type, int id )
    {
        this.amount = amount;
        Description = description;
        this.type = type;
        this.id=id;
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
