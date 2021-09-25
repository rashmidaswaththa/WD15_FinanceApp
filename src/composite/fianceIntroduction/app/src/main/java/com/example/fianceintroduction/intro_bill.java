package com.example.fianceintroduction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class intro_bill extends AppCompatActivity {

    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_income);

        button1 = findViewById(R.id.goalbtn);
        Intent intent = new Intent(intro_bill.this, intro_expense.class);
        startActivity(intent);
    }
}