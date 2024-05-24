package com.example.myapplication;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.Class.User;
import com.example.myapplication.DataBase.DataBaseHelper;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class RegistrationPage extends AppCompatActivity {
    private TextInputEditText usernameEditText;
    private TextInputEditText emailEditText;
    private TextInputEditText passwordEditText;
    private MaterialButton registrationButton;
    private DataBaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registration_page);
        usernameEditText = findViewById(R.id.username_edit_text);
        emailEditText = findViewById(R.id.email_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
        registrationButton = findViewById(R.id.registration_button);
        databaseHelper = new DataBaseHelper(this);

        registrationButton.setOnClickListener(v -> {
            String username = usernameEditText.getText().toString().trim();
            String email = emailEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();
            if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                // Show error message
                Toast.makeText(RegistrationPage.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            } else {
                User user = new User(username, password, email);
                databaseHelper.addUser(user);
                Toast.makeText(RegistrationPage.this, "User registered successfully", Toast.LENGTH_SHORT).show();
            }
        });


    }
}