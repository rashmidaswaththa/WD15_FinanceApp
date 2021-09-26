package com.example.newfinanceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class addGoalActivity extends AppCompatActivity {

    //Initialize Variables
    EditText goalNameInput, goalAmountInput, goalDesInput;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_goal);

        //Assign Variables
        //Goal insert form
        goalNameInput = findViewById(R.id.addField1_text);
        goalAmountInput = findViewById(R.id.addField2_text);
        goalDesInput = findViewById(R.id.addFeild_text3);
        add_button = findViewById(R.id.add_button);

        add_button.setOnClickListener(new View.OnClickListener(){

            MyDatabaseHelper myDB = new MyDatabaseHelper(addGoalActivity.this);

            @Override
            public void onClick(View view) {

                String name = goalNameInput.getText().toString();
                String amount = goalAmountInput.getText().toString();
                String description = goalDesInput.getText().toString();

                //making a function for validation and pass all parameters
                boolean  check= validateinfo(name,amount,description);

                if (check == true) {

                    //when data are in valid formats, input data to the databaase
                    Boolean insert = myDB.addGoal (goalNameInput.getText().toString().trim(),
                            goalAmountInput.getText().toString().trim(),
                            goalDesInput.getText().toString().trim());

                    if(insert==true){
                        Toast.makeText(addGoalActivity.this, "Inserted Successfully" , Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(addGoalActivity.this, "Error!!" , Toast.LENGTH_SHORT).show();
                    }

                    Toast.makeText(getApplicationContext(), "Data is valid",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Sorry check information again",Toast.LENGTH_SHORT).show();
                }


            }

        });


        ImageView left_arrow = findViewById(R.id.left_arrow);
        ImageView check = findViewById(R.id.check);
        TextView title = findViewById(R.id.title);

        left_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(addGoalActivity.this, "You clicked in left icon" , Toast.LENGTH_SHORT).show();
            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(addGoalActivity.this, "Inserted Successfully" , Toast.LENGTH_SHORT).show();
            }
        });

        left_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(addGoalActivity.this, MainGoalActivity.class);
                startActivity(intent);
            }
        });

        title.setText("Manage Goals");
    }

    //validation
    private boolean validateinfo(String name, String amount, String description) {
        if (name.length() == 0) {
            goalNameInput.requestFocus();
            goalNameInput.setError("THIS FIELD CAN NOT BE EMPTY");
            return false;
        } else if (!name.matches("^\\s*[\\da-zA-Z][\\da-zA-Z\\s]*$")) {
            goalNameInput.requestFocus();
            goalNameInput.setError("ENTER ONLY ALPHABETICAL CHARACTER");
            return false;
        } else if (amount.length() == 0) {
            goalAmountInput.requestFocus();
            goalAmountInput.setError("FIELD CAN NOT BE EMPTY");
            return false;
        } else if (!amount.matches("\\d+")) {
            goalAmountInput.requestFocus();
            goalAmountInput.setError("PLEASE ENTER NUMBERS");
            return false;
        } else if (description.length() == 0) {
            goalDesInput.requestFocus();
            goalDesInput.setError("FILED CAN NOT BE EMPTY");
            return false;
        } else if (!description.matches("^\\s*[\\da-zA-Z][\\da-zA-Z\\s]*$")) {
            goalDesInput.requestFocus();
            goalDesInput.setError("ENTER ONLY ALPHABETICAL CHARACTER");
            return false;
        }
        else {
            return true;
        }
    }

}