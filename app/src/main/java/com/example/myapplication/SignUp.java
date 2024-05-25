package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class SignUp extends AppCompatActivity
{
    private TextInputEditText usernameEditText;
    private TextInputEditText emailEditText;
    private TextInputEditText passwordEditText;
    private MaterialButton registrationButton;
    private TextView login;

    public List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);
        usernameEditText = findViewById(R.id.username_edit_text);
        emailEditText = findViewById(R.id.email_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
        registrationButton = findViewById(R.id.registration_button);
        login = findViewById(R.id.login_page_link_from_registration);
        users = new ArrayList<>();
       registrationButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String username = usernameEditText.getText().toString().trim();
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();
                if(username.isEmpty() || email.isEmpty() || password.isEmpty())
                {
                    Toast.makeText(SignUp.this, "Please Fill all the Fields", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    new bgthread().start();
                    Toast.makeText(SignUp.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                }

            }

        });
        login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(SignUp.this, Login.class);
                Toast.makeText(SignUp.this, "Login Page", Toast.LENGTH_SHORT).show();
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
            User user = new User( key,usernameEditText.getText().toString(),emailEditText.getText().toString() , passwordEditText.getText().toString() );
            userDao.insertAll(user);
        }
    }
}