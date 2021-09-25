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

    EditText note_input, amount_input, category_input;
    //Spinner category_input;
    Button add_button;
    ImageButton back_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_income);

        note_input = findViewById(R.id.addField1_text);
        amount_input = findViewById(R.id.addField2_text);
        category_input = findViewById(R.id.updateField3_text);
        add_button = findViewById(R.id.add_button);
        back_button = findViewById(R.id.back_button2);

        MyIncomeDatabaseHelper myDB = new MyIncomeDatabaseHelper(addIncomeActivity.this);
        add_button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

<<<<<<< HEAD
                String note = note_input.getText().toString();
                String amount = amount_input.getText().toString();
                String category = category_input.getText().toString();
=======
                Boolean insert = myDB.addIncome (note_input.getText().toString().trim(),
                        amount_input.getText().toString().trim(),
                        category_input.getText().toString().trim());
>>>>>>> 04e8260 (Add all files again)

                //making a function for validation and pass all parameters
                boolean  check= validateinfo(note,amount,category);

                if (check == true) {

                    //when data are in valid formats, input data to the databaase
                    Boolean insert = myDB.addIncome (note_input.getText().toString().trim(),
                            amount_input.getText().toString().trim(),
                            category_input.getText().toString().trim());

                    if(insert==true){
                        Toast.makeText(addIncomeActivity.this, "Inserted Successfully" , Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(addIncomeActivity.this, "Error!!" , Toast.LENGTH_SHORT).show();
                    }

                    Toast.makeText(getApplicationContext(), "Data is valid",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Sorry check information again",Toast.LENGTH_SHORT).show();
                }


            }


        });

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (addIncomeActivity.this, MainIncomeActivity.class);
                startActivity(intent);
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

    //validation
    private boolean validateinfo(String note, String amount, String category) {
        if (note.length() == 0) {
            note_input.requestFocus();
            note_input.setError("THIS FIELD CAN NOT BE EMPTY");
            return false;
        } else if (!note.matches("^\\s*[\\da-zA-Z][\\da-zA-Z\\s]*$")) {
            note_input.requestFocus();
            note_input.setError("ENTER ONLY ALPHABETICAL CHARACTER");
            return false;
        } else if (amount.length() == 0) {
            amount_input.requestFocus();
            amount_input.setError("FIELD CAN NOT BE EMPTY");
            return false;
        } else if (!amount.matches("\\d+")) {
            amount_input.requestFocus();
            amount_input.setError("PLEASE ENTER NUMBERS");
            return false;
        } else if (category.length() == 0) {
            category_input.requestFocus();
            category_input.setError("FILED CAN NOT BE EMPTY");
            return false;
        } else if (!category.matches("^\\s*[\\da-zA-Z][\\da-zA-Z\\s]*$")) {
            category_input.requestFocus();
            category_input.setError("ENTER ONLY ALPHABETICAL CHARACTER");
            return false;
        }
        else {
            return true;
        }
    }
}