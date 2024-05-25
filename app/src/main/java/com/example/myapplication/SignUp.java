package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

import com.example.myapplication.Class.ExpenseClass;
import com.example.myapplication.Class.User;
import com.example.myapplication.room.AppDatabase;
import com.example.myapplication.room.UserDao;

import java.util.ArrayList;
import java.util.List;

public class SignUp extends AppCompatActivity
{
    EditText name, email, password;
    Button signUp;
    public List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);
        name = findViewById(R.id.fullname);
        email = findViewById(R.id.email);
        password = findViewById(R.id.Password);
        signUp = findViewById(R.id.signup);
        users = new ArrayList<>();
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                new bgthread().start();

            }
        });

    }
    class bgthread extends Thread
    {
        public void run()
        {
            super.run();

            AppDatabase db = AppDatabase.getInstance(SignUp.this);
            UserDao userDao = db.userDao() ;
            users = userDao.getAll();
            int key = users.size();
            key++;
            User user = new User( key,name.getText().toString(),email.getText().toString() , password.getText().toString() );
            userDao.insertAll(user);
        }
    }
}