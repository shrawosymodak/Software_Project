package com.example.myapplication;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import com.example.myapplication.Class.TodoClass;
import com.example.myapplication.room.AppDatabase;
import com.example.myapplication.room.TodoDao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ToDoDaoTest {

    public AppDatabase db;
    public TodoDao toDoDao;
    @Before
    public void setUp() {
        db= Room.inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext(),AppDatabase.class).allowMainThreadQueries().build();
        toDoDao=db.todoDao();
    }
    @Test
    public void testInsertToDo()
    {
        TodoClass todo=new TodoClass("test",1,2,1);
        toDoDao.insertAll(todo);
    }
   @Test
    public void testGetAllToDo()
    {
        toDoDao.getAll(1);
    }
    @Test
    public void testDeleteToDo()
    {
        TodoClass todo=new TodoClass("test",1,2,1);
        toDoDao.delete(todo);
    }
    @After
    public void tearDown() {
        db.close();
    }
}
