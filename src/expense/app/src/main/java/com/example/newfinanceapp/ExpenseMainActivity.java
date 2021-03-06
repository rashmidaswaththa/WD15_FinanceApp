package com.example.newfinanceapp;

import androidx.appcompat.app.AppCompatActivity;
<<<<<<< HEAD
import androidx.recyclerview.widget.LinearLayoutManager;
=======
>>>>>>> 04e8260 (Add all files again)
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ExpenseMainActivity extends AppCompatActivity {

    RecyclerView recycle_view;
    FloatingActionButton floatButton;

    //DB helper
<<<<<<< HEAD
    ExpenseDatabaseHelper DB;
    ExpenseAdapterRecord expenseAdapterRecord;
    ArrayList<String> expense_id, expense_note, expense_amount, expense_paymethod, expense_category;
=======
    private ExpenseDatabaseHelper DB;

    ArrayList<ExpenseModelRecord> recordList;
>>>>>>> 04e8260 (Add all files again)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //Tool bar
        ImageView left_arrow = findViewById(R.id.left_arrow);
        TextView title = findViewById(R.id.title_displaylist);

        //display list and floating action button
        recycle_view = findViewById(R.id.dataDisplay_listRv);
        floatButton = findViewById(R.id.floatingAction_add);

        //init db helper class
        DB = new ExpenseDatabaseHelper(this);


        floatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newIntent = new Intent(ExpenseMainActivity.this, ExpenseAddActivity.class);
                startActivity(newIntent);
            }
        });

        left_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
<<<<<<< HEAD
                Toast.makeText(ExpenseMainActivity.this, "You clicked in left icon", Toast.LENGTH_SHORT).show();
=======
                Toast.makeText(ExpenseMainActivity.this, "You clicked in left icon" , Toast.LENGTH_SHORT).show();
>>>>>>> 04e8260 (Add all files again)
            }
        });

        title.setText("Manage Expense");
<<<<<<< HEAD

        //init db helper class
        DB = new ExpenseDatabaseHelper(ExpenseMainActivity.this);

        expense_id = new ArrayList<>();
        expense_note = new ArrayList<>();
        expense_amount = new ArrayList<>();
        expense_paymethod = new ArrayList<>();
        expense_category = new ArrayList<>();

        storeDataInArrays();

        ExpenseAdapterRecord adapterRecord = new ExpenseAdapterRecord(ExpenseMainActivity.this, this, expense_id, expense_note, expense_amount, expense_paymethod, expense_category);
        recycle_view.setAdapter(adapterRecord);
        recycle_view.setLayoutManager(new LinearLayoutManager(ExpenseMainActivity.this));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
=======
        recordList = new ArrayList<>();

        storeDataInArrays();

        ExpenseAdapterRecord adapterRecord = new ExpenseAdapterRecord(ExpenseMainActivity.this, this, recordList);
        recycle_view.setAdapter(adapterRecord);


>>>>>>> 04e8260 (Add all files again)
    }

    private void storeDataInArrays() {
        Cursor cursor = DB.readAllData();
<<<<<<< HEAD

        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                expense_id.add(cursor.getString(0));
                expense_note.add(cursor.getString(1));
                expense_amount.add(cursor.getString(2));
                expense_paymethod.add(cursor.getString(3));
                expense_category.add(cursor.getString(4));
            }
        }

    }
}




=======
        ExpenseModelRecord modelRecord;


        if(cursor.getCount() == 0){
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                modelRecord = new ExpenseModelRecord();
                modelRecord.setId((cursor.getString(0)));
                modelRecord.setNote(cursor.getString(1));
                modelRecord.setAmount(cursor.getString(2));
                modelRecord.setPay_method(cursor.getString(3));
                modelRecord.setCategory(cursor.getString(4));
                recordList.add(modelRecord);

            }
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
>>>>>>> 04e8260 (Add all files again)
