package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.myapplication.Class.User;
import com.example.myapplication.roomdatabase.AppDatabase;
import com.example.myapplication.roomdatabase.UserDao;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class RegistrationPage extends AppCompatActivity {
    private TextInputEditText usernameEditText;
    private TextInputEditText emailEditText;
    private TextInputEditText passwordEditText;
    private MaterialButton registrationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registration_page);
        usernameEditText = findViewById(R.id.username_edit_text);
        emailEditText = findViewById(R.id.email_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
        registrationButton = findViewById(R.id.registration_button);

        registrationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString().trim();
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();
                if(username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(RegistrationPage.this, "Please Fill all the Fields", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    new bgthread().start();
                    Toast.makeText(RegistrationPage.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    class bgthread extends Thread {
        public void run() {
            super.run();
            AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "main_db")
                    .build();
            UserDao userDao = db.userDao();
            User user = new User( usernameEditText.getText().toString(), emailEditText.getText().toString(), passwordEditText.getText().toString());

            userDao.insert(user);
        }
    }

}
