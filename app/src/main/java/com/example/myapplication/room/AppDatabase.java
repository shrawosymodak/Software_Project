package com.example.myapplication.room;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.example.myapplication.Class.BalanceClass;
import com.example.myapplication.Class.ExpenseClass;
import com.example.myapplication.Class.User;

    @Database(entities = {User.class , BalanceClass.class , ExpenseClass.class}, version = 5)
    public abstract class AppDatabase extends RoomDatabase
    {
        public abstract UserDao userDao();
        public abstract BalanceDao balanceDao();
        public abstract ExpenseDao expenseDao();

        private static final String DB_NAME = "mainDb";
        private static AppDatabase instance;
        public static synchronized AppDatabase getInstance(@NonNull final Context context)
        {
            if (instance == null)
            {
                instance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DB_NAME)
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build();
            }
            return instance;
        }

    }
