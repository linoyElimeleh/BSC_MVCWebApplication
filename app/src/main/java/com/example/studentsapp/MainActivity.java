package com.example.studentsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("TAG", "MainActivity onCreate");

        Intent loginIntent = new Intent(this, ListActivity.class);
        Button loginBtn = findViewById(R.id.login_btn);
        loginBtn.setOnClickListener(v -> startActivity(loginIntent));
    }
}