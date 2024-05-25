package com.example.myapplication.Class;

public class ExpenseManager
{
    ExpenseClass expense;

    public ExpenseClass addExpense(String type , String description , int amount , int key , int id)
    {
        expense = new ExpenseClass(amount, description , type , key , id );
        return expense;
    }
}
