package com.example.newfinanceapp;

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

public class updateIncomeActivity extends AppCompatActivity {

    //Assign variables
    EditText note_input, amount_input, category_input;
    Button update_button;
    ImageButton back_button2 , delete_button;

    String id, note, amount, category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_income);

        //Initialize variables
        note_input = findViewById(R.id.updateField1_text);
        amount_input = findViewById(R.id.updateField2_text);
        category_input = findViewById(R.id.updateField3_text);
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
                //Creating database connection
                MyDatabaseHelper myDB = new MyDatabaseHelper(updateIncomeActivity.this);
                note = note_input.getText().toString().trim();
                amount = amount_input.getText().toString().trim();
                category = category_input.getText().toString().trim();
                myDB.updateData(id, note, amount, category);
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
                //Creating intent for back button
                Intent intent = new Intent (updateIncomeActivity.this, MainIncomeActivity.class);
                startActivity(intent);
            }
        });

    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("note") &&
                getIntent().hasExtra("amount") && getIntent().hasExtra("category")){
            //Getting Data from Intent
            id = getIntent().getStringExtra("id");
            note = getIntent().getStringExtra("note");
            amount = getIntent().getStringExtra("amount");
            category = getIntent().getStringExtra("category");

            //Setting Intent Data
            note_input.setText(note);
            amount_input.setText(amount);
            category_input.setText(category);
            Log.d("stev", note+" "+amount+" "+category);
        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }



   void confirmDialog(){
        //Confirmation message for delete
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + note + " ?");
        builder.setMessage("Are you sure you want to delete " + note + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(updateIncomeActivity.this);
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
