package com.example.myapplication.Class;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExpenseManagerTest {

    @Test
    public void addExpense()
    {
        ExpenseManager expenseManager = new ExpenseManager();
        ExpenseClass expense = expenseManager.addExpense("Food", "Bought some food", 100, 1, 1);
        assertEquals("Food", expense.getType());
        assertEquals("Bought some food", expense.getDescription());
        assertEquals(100, expense.getAmount());
        assertEquals(1, expense.getId());
    }
}