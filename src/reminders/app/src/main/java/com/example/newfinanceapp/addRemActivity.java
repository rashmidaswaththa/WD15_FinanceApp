package com.example.newfinanceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class addRemActivity extends AppCompatActivity {

    EditText Rtype_input, Ramount_input,Rdate_input;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_Rem);

        Rtype_input = findViewById(R.id.addReminder_text);
        Ramount_input = findViewById(R.id.addReminder2_text);
        Rdate_input = findViewById(R.id.ReminderTextDate);
        add_button = findViewById(R.id.add_button);

        MyRemDatabaseHelper myDB = new MyRemDatabaseHelper(addRemActivity.this);
        add_button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Boolean insert = myDB.addReminder (Rtype_input.getText().toString().trim(),
                        Ramount_input.getText().toString().trim(),
                        Rdate_input.getText().toString().trim());


                if(insert==true){
                    Toast.makeText(addRemActivity.this, "Inserted Successfully" , Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(addRemActivity.this, "Error!!" , Toast.LENGTH_SHORT).show();
                }
            }
        });

        ImageView left_arrow = findViewById(R.id.left_arrow);
        ImageView check = findViewById(R.id.check);
        TextView title = findViewById(R.id.title);

        left_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(addRemActivity.this, "You clicked in left icon" , Toast.LENGTH_SHORT).show();
            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(addRemActivity.this, "Inserted Successfully" , Toast.LENGTH_SHORT).show();
            }
        });

        title.setText("Manage Reminder");
    }
}