package com.example.newfinanceapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class updateExpenseActivity extends AppCompatActivity {


    //views
    private EditText note_text, category_text, method_text,amount_text;
    private Button update_button;

    //db helper
    MyDatabaseHelper myDB;


    String note;
    String id;
    String amount;
    String method;
    String category;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_expense);

        //init views

        note_text = findViewById(R.id.addField1_text);
        amount_text = findViewById(R.id.addField2_text);
        method_text = findViewById(R.id.editText_cash);
        category_text = findViewById(R.id.editText_category);
        update_button = findViewById(R.id.update_btn);

        //init db helper class
        myDB = new MyDatabaseHelper(this);

        //Tool bar
        ImageButton left_arrow1 = findViewById(R.id.left_arrow1);
        ImageView check = findViewById(R.id.check);
        TextView title = findViewById(R.id.title);
        ImageButton clear = findViewById(R.id.clear);

        //First we call this
        getAndSetIntentData();

        left_arrow1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(updateExpenseActivity.this, MainExpenseActivity.class);
                startActivity(intent);
            }
        });


        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDB = new MyDatabaseHelper(updateExpenseActivity.this);
                note = note_text.getText().toString().trim();
                amount = amount_text.getText().toString().trim();
                method = method_text.getText().toString().trim();
                category = category_text.getText().toString().trim();
                myDB.updateDataExpense(id, note, amount, method, category);

            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();
            }
        });

    }

    private void getAndSetIntentData() {
        if (getIntent().hasExtra("id") && getIntent().hasExtra("note") &&
                getIntent().hasExtra("amount") && getIntent().hasExtra("method") && getIntent().hasExtra("category")) {
            //Getting Data from Intent
            //Intent intent = new Intent (context, UpdateExpenseActivity.class);
             id= getIntent().getStringExtra("id");
            note = getIntent().getStringExtra("note");
            amount = getIntent().getStringExtra("amount");
            method = getIntent().getStringExtra("method");
            category = getIntent().getStringExtra("category");

            //set data

            note_text.setText(note);
            amount_text.setText(amount);
            method_text.setText(method);
            category_text.setText(category);

            Log.d("stev", note+" "+amount+" "+method+" "+category);
        } else {
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }


    private void confirmDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + note + " ?");
        builder.setMessage("Are you sure you want to delete " + note + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(updateExpenseActivity.this);
                myDB.deleteOneRowExpense(id);
                //finish();
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