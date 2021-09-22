package com.example.newfinanceapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class MainIncomeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton add;

    MyIncomeDatabaseHelper myDB;
    ArrayList<String> income_id, income_note, income_amount, income_category;
    CustomAdapter customAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_income);

        recyclerView = findViewById(R.id.recycleView);
        add = findViewById(R.id.add_button);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (MainIncomeActivity.this, addIncomeActivity.class);
                startActivity(intent);
            }
        });

        ImageView left_arrow = findViewById(R.id.left_arrow);
        ImageView check = findViewById(R.id.check);
        ImageView clear = findViewById(R.id.clear);
        TextView title = findViewById(R.id.title);

        left_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainIncomeActivity.this, "You clicked in left icon" , Toast.LENGTH_SHORT).show();
            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainIncomeActivity.this, "Inserted Successfully" , Toast.LENGTH_SHORT).show();
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainIncomeActivity.this, "Deleted Successfully" , Toast.LENGTH_SHORT).show();
            }
        });

        title.setText("Manage Income");

        myDB = new MyIncomeDatabaseHelper(MainIncomeActivity.this);
        income_id = new ArrayList<>();
        income_note = new ArrayList<>();
        income_amount = new ArrayList<>();
        income_category = new ArrayList<>();

        storeDataInArrays();

        customAdapter = new CustomAdapter(MainIncomeActivity.this,this,income_id, income_note, income_amount, income_category);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainIncomeActivity.this));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            recreate();
        }
    }

   void storeDataInArrays(){
       Cursor cursor = myDB.readAllData();
        if(cursor.getCount() == 0){
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                income_id.add(cursor.getString(0));
                income_note.add(cursor.getString(1));
                income_amount.add(cursor.getString(2));
                income_category.add(cursor.getString(3));
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

}