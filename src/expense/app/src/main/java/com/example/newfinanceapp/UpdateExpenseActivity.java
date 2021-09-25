package com.example.newfinanceapp;

<<<<<<< HEAD
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
=======
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
>>>>>>> 04e8260 (Add all files again)
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
<<<<<<< HEAD
import androidx.appcompat.app.AppCompatActivity;
=======

import android.content.DialogInterface;
>>>>>>> 04e8260 (Add all files again)

public class UpdateExpenseActivity extends AppCompatActivity {


    //views
<<<<<<< HEAD
    private EditText note_text, category_text, method_text,amount_text;
    private Button update_button;


    //db helper
    ExpenseDatabaseHelper myDB;
=======


    private EditText note_text, category_text, method_text;
    private EditText amount_text;
    private Button update_button;


    private String recordId;

    //db helper
    ExpenseDatabaseHelper DB;
>>>>>>> 04e8260 (Add all files again)


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
<<<<<<< HEAD
        myDB = new ExpenseDatabaseHelper(this);

        //Tool bar
        ImageButton left_arrow1 = findViewById(R.id.left_arrow1);
        ImageView check = findViewById(R.id.check);
        TextView title = findViewById(R.id.title);
        ImageButton clear = findViewById(R.id.clear);
=======
        DB = new ExpenseDatabaseHelper(this);

        //Tool bar
        ImageView left_arrow = findViewById(R.id.left_arrow);
        ImageView check = findViewById(R.id.check);
        TextView title = findViewById(R.id.title);
        ImageView clear = findViewById(R.id.clear);
>>>>>>> 04e8260 (Add all files again)

        //First we call this
        getAndSetIntentData();

<<<<<<< HEAD
        left_arrow1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
=======
        left_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
>>>>>>> 04e8260 (Add all files again)
                Intent intent = new Intent(UpdateExpenseActivity.this, ExpenseMainActivity.class);
                startActivity(intent);
            }
        });

<<<<<<< HEAD

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDB = new ExpenseDatabaseHelper(UpdateExpenseActivity.this);
=======
        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DB = new ExpenseDatabaseHelper(UpdateExpenseActivity.this);
>>>>>>> 04e8260 (Add all files again)
                note = note_text.getText().toString().trim();
                amount = amount_text.getText().toString().trim();
                method = method_text.getText().toString().trim();
                category = category_text.getText().toString().trim();
<<<<<<< HEAD
                myDB.updateData(id, note, amount, method,  category);
=======
                DB.updateData(id, note, amount, method,  category);
>>>>>>> 04e8260 (Add all files again)

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
<<<<<<< HEAD
        if (getIntent().hasExtra("id") && getIntent().hasExtra("note") &&
                getIntent().hasExtra("amount") && getIntent().hasExtra("method") && getIntent().hasExtra("category")) {
            //Getting Data from Intent
            //Intent intent = new Intent (context, UpdateExpenseActivity.class);
             id= getIntent().getStringExtra("id");
            note = getIntent().getStringExtra("note");
            amount = getIntent().getStringExtra("amount");
            method = getIntent().getStringExtra("method");
            category = getIntent().getStringExtra("category");
=======
        if (getIntent().hasExtra("_id") && getIntent().hasExtra("expense_note") &&
                getIntent().hasExtra("expense_amount") && getIntent().hasExtra("payment_method") && getIntent().hasExtra("expense_category")) {
            //Getting Data from Intent
            //Intent intent = new Intent (context, UpdateExpenseActivity.class);
            recordId = getIntent().getStringExtra("_id");
            note = getIntent().getStringExtra("expense_note");
            amount = getIntent().getStringExtra("expense_amount");
            method = getIntent().getStringExtra("payment_method");
            category = getIntent().getStringExtra("expense_category");
>>>>>>> 04e8260 (Add all files again)

            //set data

            note_text.setText(note);
            amount_text.setText(amount);
            method_text.setText(method);
            category_text.setText(category);
<<<<<<< HEAD

            Log.d("stev", note+" "+amount+" "+method+" "+category);
=======
>>>>>>> 04e8260 (Add all files again)
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
<<<<<<< HEAD
                ExpenseDatabaseHelper myDB = new ExpenseDatabaseHelper(UpdateExpenseActivity.this);
                myDB.deleteOneRow(id);
=======

                DB.deleteOneRow(recordId);
>>>>>>> 04e8260 (Add all files again)
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