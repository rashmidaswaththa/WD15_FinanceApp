package com.example.fianceintroduction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class intro_expense extends AppCompatActivity {

    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_expense);

        button1 = findViewById(R.id.expense_btn);
        Intent intent = new Intent(intro_expense.this, intro_goal.class);
        startActivity(intent);
    }
}