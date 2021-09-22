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

public class addActivity extends AppCompatActivity {

    EditText goalNameInput, goalAmountInput, goalDesInput;
    Button add_button;
    ImageButton back_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        goalNameInput = findViewById(R.id.addField1_text);
        goalAmountInput = findViewById(R.id.addField2_text);
        goalDesInput = findViewById(R.id.addFeild_text3);
        add_button = findViewById(R.id.add_button);

        MyDatabaseHelper myDB = new MyDatabaseHelper(addActivity.this);
        add_button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Boolean insert = myDB.addGoal (goalNameInput.getText().toString().trim(),
                        goalAmountInput.getText().toString().trim(),
                        goalDesInput.getText().toString().trim());

                if(insert==true){
                    Toast.makeText(addActivity.this, "Inserted Successfully" , Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(addActivity.this, "Error!!" , Toast.LENGTH_SHORT).show();
                }
            }
        });

         back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (addActivity.this, MainActivity.class);
                startActivity(intent);
            }
         });

        ImageView left_arrow = findViewById(R.id.left_arrow);
        ImageView check = findViewById(R.id.check);
        TextView title = findViewById(R.id.title);

        left_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(addActivity.this, "You clicked in left icon" , Toast.LENGTH_SHORT).show();
            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(addActivity.this, "Inserted Successfully" , Toast.LENGTH_SHORT).show();
            }
        });

        title.setText("Manage Goals");
    }
}