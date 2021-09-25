package com.example.newfinanceapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class addExpenseActivity extends AppCompatActivity {


    //insert form
    private EditText note_text;
    private EditText amount_text;
    private EditText method_text;
    private EditText category_text;
    private Button add_button;


    MyDatabaseHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Tool bar
        ImageView left_arrow = findViewById(R.id.left_arrow);
        ImageView check = findViewById(R.id.check);
        TextView title = findViewById(R.id.title);
        ImageView clear = findViewById(R.id.clear);


        //Expense insert form

        note_text = findViewById(R.id.addField1_text);
        amount_text = findViewById(R.id.addField2_text);
        method_text = findViewById(R.id.editText_cash);
        category_text = findViewById(R.id.editText_category);
        add_button = findViewById(R.id.add_btn);


        //date base connection
        DB = new MyDatabaseHelper(this);


        left_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(addExpenseActivity.this, MainExpenseActivity.class);
                startActivity(intent);
            }
        });

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String note = note_text.getText().toString().trim();
                String amount = amount_text.getText().toString().trim();
                String pay = method_text.getText().toString().trim();
                String cat = category_text.getText().toString().trim();

                //byte[] image = onActivityResult(requestCode, resultCode, data).image;
                boolean insert = DB.insertData(note, amount, pay, cat); //insert entered data to the database

                if (insert) {
                    //display success message when data is inserted to the database successfully
                    Toast.makeText(addExpenseActivity.this, "Inserted Successfully", Toast.LENGTH_SHORT).show();
                } else {
                    //display error message when data is not inserted to the database
                    Toast.makeText(addExpenseActivity.this, "Failed!", Toast.LENGTH_SHORT).show();
                }


            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(addExpenseActivity.this, "", Toast.LENGTH_SHORT).show();
            }
        });

        title.setText("Manage Expense");

    }


}






