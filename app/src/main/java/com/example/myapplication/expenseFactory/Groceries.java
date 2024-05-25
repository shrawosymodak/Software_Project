package com.example.myapplication.expenseFactory;

public class Groceries implements Items{
    private String name;

    @Override
    public void setItemName() {
        name = "Groceries";
    }

    @Override
    public String getItemName() {
        return name;
    }
}
