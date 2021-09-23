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

import androidx.appcompat.app.AlertDialog;

import android.content.DialogInterface;

public class UpdateExpenseActivity extends AppCompatActivity {


    //views


    private EditText note_text, category_text, method_text;
    private EditText amount_text;
    private Button update_button;


    private String recordId;

    //db helper
    ExpenseDatabaseHelper DB;


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
        DB = new ExpenseDatabaseHelper(this);

        //Tool bar
        ImageView left_arrow = findViewById(R.id.left_arrow);
        ImageView check = findViewById(R.id.check);
        TextView title = findViewById(R.id.title);
        ImageView clear = findViewById(R.id.clear);

        //First we call this
        getAndSetIntentData();

        left_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UpdateExpenseActivity.this, ExpenseMainActivity.class);
                startActivity(intent);
            }
        });

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DB = new ExpenseDatabaseHelper(UpdateExpenseActivity.this);
                note = note_text.getText().toString().trim();
                amount = amount_text.getText().toString().trim();
                method = method_text.getText().toString().trim();
                category = category_text.getText().toString().trim();
                DB.updateData(id, note, amount, method,  category);

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
        if (getIntent().hasExtra("_id") && getIntent().hasExtra("expense_note") &&
                getIntent().hasExtra("expense_amount") && getIntent().hasExtra("payment_method") && getIntent().hasExtra("expense_category")) {
            //Getting Data from Intent
            //Intent intent = new Intent (context, UpdateExpenseActivity.class);
            recordId = getIntent().getStringExtra("_id");
            note = getIntent().getStringExtra("expense_note");
            amount = getIntent().getStringExtra("expense_amount");
            method = getIntent().getStringExtra("payment_method");
            category = getIntent().getStringExtra("expense_category");

            //set data

            note_text.setText(note);
            amount_text.setText(amount);
            method_text.setText(method);
            category_text.setText(category);
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

                DB.deleteOneRow(recordId);
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