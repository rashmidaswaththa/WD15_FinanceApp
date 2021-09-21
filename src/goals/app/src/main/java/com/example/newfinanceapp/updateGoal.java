package com.example.newfinanceapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class updateGoalActivity extends AppCompatActivity {

    EditText goal_input, amount_input, desc_input;
    Button update_button;
    ImageButton back_button2 , delete_button;

    String id, goal, amount, desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_income);

        goal_input = findViewById(R.id.updateField1_text);
        amount_input = findViewById(R.id.updateField2_text);
        desc_input = findViewById(R.id.updateField3_text);
        update_button = findViewById(R.id.update_button);
        back_button2 = findViewById(R.id.back_button2);
        delete_button = findViewById(R.id.delete_button);

        //First we call this
        getAndSetIntentData();

        //Set actionbar title after getAndSetIntentData method
        /*ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(title);
        }*/

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //And only then we call this
                MyDatabaseHelper myDB = new MyDatabaseHelper(updateGoalActivity.this);
                goal = goal_input.getText().toString().trim();
                amount = amount_input.getText().toString().trim();
                desc = desc_input.getText().toString().trim();
                myDB.updateData(id, goal, amount, desc);
            }
        });
        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();
            }
        });

        back_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (updateGoalActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("goal") &&
                getIntent().hasExtra("amount") && getIntent().hasExtra("desc")){
            //Getting Data from Intent
            id = getIntent().getStringExtra("id");
            note = getIntent().getStringExtra("goal");
            amount = getIntent().getStringExtra("amount");
            category = getIntent().getStringExtra("desc");

            //Setting Intent Data
            note_input.setText(goal);
            amount_input.setText(amount);
            category_input.setText(desc);
            Log.d("stev", goal+" "+amount+" "+desc);
        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }



   void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + goal + " ?");
        builder.setMessage("Are you sure you want to delete " + goal + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(updateGoalActivity.this);
                myDB.deleteOneRow(id);
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }
}
