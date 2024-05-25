package com.example.myapplication.expenseFactory;

public class Transport implements Items{
    private String name;

    @Override
    public void setItemName() {
        name = "Transport";
    }

    @Override
    public String getItemName() {
        return name;
    }
}
