package com.example.myapplication;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import com.example.myapplication.Class.BalanceClass;
import com.example.myapplication.room.AppDatabase;
import com.example.myapplication.room.BalanceDao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BalanceDaoTest {
    public AppDatabase db;
    public BalanceDao balanceDao;
    @Before
    public void setUp() {
        db= Room.inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext(),AppDatabase.class).allowMainThreadQueries().build();
        balanceDao=db.balanceDao();
    }
    @Test
    public void testInsertBalance()
    {
        BalanceClass balance = new BalanceClass(1, 1, 1);
        balanceDao.insertAll(balance);
    }
    @Test
    public void testGetAllBalance()
    {
        balanceDao.getAll(1);
    }
    @Test
    public void testUpdateBalance()
    {
        BalanceClass balance = new BalanceClass(1, 1, 1);
        balanceDao.update(balance);
    }
    @Test
    public void testDeleteBalance()
    {
        BalanceClass balance = new BalanceClass(1, 1, 1);
        balanceDao.delete(balance);
    }
    @After
    public void tearDown() {
        db.close();
    }

}
