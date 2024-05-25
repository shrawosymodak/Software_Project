package com.example.myapplication.expenseFactory;

public class Foods implements Items{
    private String name;

    @Override
    public void setItemName() {
        name = "Foods";
    }

    @Override
    public String getItemName() {
        return name;
    }
}
