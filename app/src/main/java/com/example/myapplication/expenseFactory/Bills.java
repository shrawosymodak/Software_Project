package com.example.myapplication.expenseFactory;

public class Bills implements Items{
    private String name;

    @Override
    public void setItemName() {
        name = "Bills";
    }

    @Override
    public String getItemName() {
        return name;
    }
}
