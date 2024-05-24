package com.example.myapplication.mainfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.myapplication.R;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityFragmentmainBinding;
import com.example.myapplication.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class fragmentmain extends AppCompatActivity {
    ActivityFragmentmainBinding binding;


    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragmentmain);
        //binding = ActivityFragmentmainBinding.inflate(getLayoutInflater());
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_menu);

        replaceFragment(new TodoFragment());

        setContentView(bottomNavigationView.getRoot());
        bottomNavigationView.bottom.setOnItemSelectedListener(item -> {
            if(item.getItemId()==R.id.todo)
                replaceFragment(new TodoFragment());
            else if(item.getItemId()==R.id.habit)
                replaceFragment(new habitFragment());
            else if(item.getItemId()==R.id.progress)
                replaceFragment(new progressFragment());
            else if(item.getItemId()==R.id.expense)
                replaceFragment(new expenseFragment());
            return true;
        });
    }
    private void replaceFragment(Fragment fragment)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame,fragment);
        fragmentTransaction.commit();
    }
}

