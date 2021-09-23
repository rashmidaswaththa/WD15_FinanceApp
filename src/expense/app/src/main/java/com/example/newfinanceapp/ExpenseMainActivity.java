package com.example.newfinanceapp;

import androidx.appcompat.app.AppCompatActivity;
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
    private ExpenseDatabaseHelper DB;

    ArrayList<ExpenseModelRecord> recordList;

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
                Toast.makeText(ExpenseMainActivity.this, "You clicked in left icon" , Toast.LENGTH_SHORT).show();
            }
        });

        title.setText("Manage Expense");
        recordList = new ArrayList<>();

        storeDataInArrays();

        ExpenseAdapterRecord adapterRecord = new ExpenseAdapterRecord(ExpenseMainActivity.this, this, recordList);
        recycle_view.setAdapter(adapterRecord);


    }

    private void storeDataInArrays() {
        Cursor cursor = DB.readAllData();
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