package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;


import com.example.myapplication.Class.User;
import com.example.myapplication.Class.UserSingleton;
import com.example.myapplication.mainfragment.fragmentmain;
import com.example.myapplication.room.AppDatabase;
import com.example.myapplication.room.UserDao;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class Login extends AppCompatActivity {
    private TextInputEditText emailEditText;
    private TextInputEditText passwordEditText;
    private TextView reg;
    private Button loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        emailEditText = findViewById(R.id.emailLogin);
        passwordEditText = findViewById(R.id.passwordLogin);
        loginButton = findViewById(R.id.login_button);
        reg = findViewById(R.id.dont);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Login.this, SignUp.class);
                startActivity(intent);

            }
        });


        loginButton.setOnClickListener(v -> {
            String username = emailEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();
            if(username.isEmpty() || password.isEmpty()) {
                Toast.makeText(Login.this, "Please Fill all the Fields", Toast.LENGTH_SHORT).show();
            }
            else
            {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "mainDb")
                                .build();
                        UserDao userDao = db.userDao();
                        User user = userDao.loginuser(emailEditText.getText().toString(), passwordEditText.getText().toString());
                        if (user != null) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    UserSingleton.getInstance().setUser(user);
                                    Toast.makeText(Login.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(Login.this, fragmentmain.class);
                                    startActivity(intent);
                                }
                            });
                        } else {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(Login.this, "Wrong Id or Password", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }
                }).start();
            }
        });



    }

//    class bgthread extends Thread {
//        public void run() {
//            super.run();
//            AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "mainDb")
//                    .build();
//            UserDao userDao = db.userDao();
//            User user = userDao.loginuser(emailEditText.getText().toString(), passwordEditText.getText().toString());
//            if (user != null) {
//                Toast.makeText(Login.this, "Login Successfully", Toast.LENGTH_SHORT).show();
//            } else {
//                Toast.makeText(Login.this, "Wrong Id or Password", Toast.LENGTH_SHORT).show();
//            }
//
//        }
//    }

}