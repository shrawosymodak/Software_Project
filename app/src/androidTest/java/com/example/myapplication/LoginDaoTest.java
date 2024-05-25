package com.example.myapplication;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import com.example.myapplication.Class.User;
import com.example.myapplication.room.AppDatabase;
import com.example.myapplication.room.UserDao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LoginDaoTest {
    public AppDatabase db;
    public UserDao userDao;
    @Before
    public void setUp() {
        db= Room.inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext(),AppDatabase.class).allowMainThreadQueries().build();
        userDao=db.userDao();
    }
    @Test
    public void testlogin(){
        User user=new User();
        user.setLastName("test@gmail.com");
        user.setPassword("123456");
        userDao.loginuser(user.getLastName(),user.getPassword());

    }
    @After
    public void tearDown() {
        db.close();
    }
}
