package com.example.myapplication;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import com.example.myapplication.Class.User;
import com.example.myapplication.room.AppDatabase;
import com.example.myapplication.room.UserDao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class signUpDaoTest {
    public AppDatabase db;
    public UserDao userDao;
    @Before
    public void setUp() {
        db= Room.inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext(),AppDatabase.class).allowMainThreadQueries().build();
        userDao=db.userDao();
    }
    @Test
    public void testInsertUser(){
        User user=new User(1,"John","John@gmail.com","123456");
        userDao.insertAll(user);
    }
    @After
    public void tearDown() {
        db.close();
    }

}
