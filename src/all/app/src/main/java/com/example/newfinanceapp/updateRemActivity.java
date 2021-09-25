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

public class updateRemActivity extends AppCompatActivity {

    EditText type_input, amount_input, date_input;
    Button update_button;
    ImageButton back_button2 , delete_button;

    String id, type, amount, date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_reminder);

        type_input = findViewById(R.id.updateField1_text);
        amount_input = findViewById(R.id.updateField2_text);
        date_input = findViewById(R.id.updateDate3);
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
                MyDatabaseHelper myDB = new MyDatabaseHelper(updateRemActivity.this);
                type = type_input.getText().toString().trim();
                amount = amount_input.getText().toString().trim();
                date = date_input.getText().toString().trim();
                myDB.updateDataRem(id, type, amount, date);
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
                Intent intent = new Intent (updateRemActivity.this, MainRemActivity.class);
                startActivity(intent);
            }
        });

    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("type") &&
                getIntent().hasExtra("amount") && getIntent().hasExtra("date")){
            //Getting Data from Intent
            id = getIntent().getStringExtra("id");
            type = getIntent().getStringExtra("type");
            amount = getIntent().getStringExtra("amount");
            date = getIntent().getStringExtra("date");

            //Setting Intent Data
            type_input.setText(type);
            amount_input.setText(amount);
            date_input.setText(date);
            Log.d("stev", type+" "+amount+" "+date);
        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }



   void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + type+ " ?");
        builder.setMessage("Are you sure you want to delete " +type  + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(updateRemActivity.this);
                myDB.deleteOneRowRem(id);
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
