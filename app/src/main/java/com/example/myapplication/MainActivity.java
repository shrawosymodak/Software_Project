package com.example.myapplication;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.mainfragment.fragmentmain;


public class MainActivity extends AppCompatActivity {
    private Button logIn;
    private TextView Dont;
    private EditText usr,pass;
//    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logIn = findViewById(R.id.Login);
        Dont = findViewById(R.id.dont);
        usr = findViewById(R.id.username);
        pass = findViewById(R.id.Password);
//        mAuth = FirebaseAuth.getInstance();

        Dont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, SignUp.class);
                startActivity(intent);
            }
        });
        logIn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String user = usr.getText().toString();
                String password = pass.getText().toString();
                Intent intent = new Intent(MainActivity.this, fragmentmain.class);
                startActivity(intent);
                //   mAuth.signInWithEmailAndPassword(user,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task)
//            {
//                        if(task.isSuccessful())
//                        {
//                        }
//                        else
//                        {
//                            Toast.makeText(MainActivity.this, "Wrong Id or Password", Toast.LENGTH_SHORT).show();
//                        }
//
//                    }
//                });
            }
        });
    }
}