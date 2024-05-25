package com.example.myapplication.expenseFactory;

public class Miscellaneous implements Items{
    private String name;

    @Override
    public void setItemName() {
        name = "Miscellaneous";
    }

    @Override
    public String getItemName() {
        return name;
    }
}
