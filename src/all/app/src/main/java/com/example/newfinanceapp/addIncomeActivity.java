package com.example.newfinanceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class addIncomeActivity extends AppCompatActivity {

    //Initialize variables
    EditText note_input, amount_input, category_input;
    //Spinner category_input;
    Button add_button;
    ImageButton back_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_income);

        //Assign variables
        note_input = findViewById(R.id.addField1_text);
        amount_input = findViewById(R.id.addField2_text);
        category_input = findViewById(R.id.updateField3_text);
        add_button = findViewById(R.id.add_button);
        back_button = findViewById(R.id.back_button2);

        MyDatabaseHelper myDB = new MyDatabaseHelper(addIncomeActivity.this);
        add_button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                //Inserting data to the database
                Boolean insert = myDB.addIncome (note_input.getText().toString().trim(),
                        amount_input.getText().toString().trim(),
                        category_input.getText().toString().trim());

                if(insert==true){
                    //Display success message when data inserted Successfully to the data base
                    Toast.makeText(addIncomeActivity.this, "Inserted Successfully" , Toast.LENGTH_SHORT).show();
                }
                else{
                    //Display an error message when data is not entered to the database
                    Toast.makeText(addIncomeActivity.this, "Error!!" , Toast.LENGTH_SHORT).show();
                }
            }


        });

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Creating intents
                Intent intent = new Intent (addIncomeActivity.this, MainIncomeActivity.class);
                startActivity(intent);
            }
         });

        //Assign variables
        ImageView left_arrow = findViewById(R.id.left_arrow);
        ImageView check = findViewById(R.id.check);
        TextView title = findViewById(R.id.title);

        left_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Display a toast message when you click the back arrow
                Toast.makeText(addIncomeActivity.this, "You clicked in left icon" , Toast.LENGTH_SHORT).show();
            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Display success message when data inserted Successfully to the data base
                Toast.makeText(addIncomeActivity.this, "Inserted Successfully" , Toast.LENGTH_SHORT).show();
            }
        });

        title.setText("Manage Income");
    }
}