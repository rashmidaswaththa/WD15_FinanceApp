package com.example.newfinanceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class addIncomeActivity extends AppCompatActivity {

    EditText note_input, amount_input;
    Spinner category_input;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_income);

        note_input = findViewById(R.id.addField1_text);
        amount_input = findViewById(R.id.addField2_text);
        category_input = findViewById(R.id.category_list);
        add_button = findViewById(R.id.add_button);

        MyIncomeDatabaseHelper myDB = new MyIncomeDatabaseHelper(addIncomeActivity.this);
        add_button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Boolean insert = myDB.addIncome (note_input.getText().toString().trim(),
                        amount_input.getText().toString().trim(),
                        category_input.getSelectedItem().toString().trim());

                if(insert==true){
                    Toast.makeText(addIncomeActivity.this, "Inserted Successfully" , Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(addIncomeActivity.this, "Error!!" , Toast.LENGTH_SHORT).show();
                }
            }
        });

        ImageView left_arrow = findViewById(R.id.left_arrow);
        ImageView check = findViewById(R.id.check);
        TextView title = findViewById(R.id.title);

        left_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(addIncomeActivity.this, "You clicked in left icon" , Toast.LENGTH_SHORT).show();
            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(addIncomeActivity.this, "Inserted Successfully" , Toast.LENGTH_SHORT).show();
            }
        });

        title.setText("Manage Income");
    }
}