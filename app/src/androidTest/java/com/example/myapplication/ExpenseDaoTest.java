package com.example.myapplication;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import com.example.myapplication.Class.ExpenseClass;
import com.example.myapplication.room.AppDatabase;
import com.example.myapplication.room.ExpenseDao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExpenseDaoTest {
    public AppDatabase appDatabase;
    public ExpenseDao expenseDao;
    @Before
    public void setUp() {
        appDatabase= Room.inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext(),AppDatabase.class).allowMainThreadQueries().build();
        expenseDao=appDatabase.expenseDao();
    }
    @Test
    public void testInsertExpense()
    {
        ExpenseClass expense = new ExpenseClass(1,"test","test",1,1);
        expenseDao.insertAll(expense);
    }
    @Test
    public void testGetAllExpense()
    {
        expenseDao.getAll(1);
    }
    @Test
    public void testDeleteExpense()
    {
        ExpenseClass expense = new ExpenseClass(1,"test","test",1,1);
        expenseDao.delete(expense);
    }

    @After
    public void tearDown() {
        appDatabase.close();
    }
}
