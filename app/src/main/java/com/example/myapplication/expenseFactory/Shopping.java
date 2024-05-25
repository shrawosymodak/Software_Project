package com.example.myapplication.expenseFactory;

public class Shopping implements Items{
    private String name;

    @Override
    public void setItemName() {
        name = "Shopping";
    }

    @Override
    public String getItemName() {
        return name;
    }
}
