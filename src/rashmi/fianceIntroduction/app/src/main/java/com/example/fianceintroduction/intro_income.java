package com.example.fianceintroduction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class intro_income extends AppCompatActivity {

    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_income);

        button1 = findViewById(R.id.incomebtn);
        Intent intent = new Intent(intro_income.this, intro_expense.class);
        startActivity(intent);
    }
}