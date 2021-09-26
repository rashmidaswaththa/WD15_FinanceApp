package com.example.newfinanceapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainRemActivity extends AppCompatActivity {

    //Initialize variables
    RecyclerView recyclerView;
    FloatingActionButton add;
    CustomRemAdapter customAdapter;

    MyRemDatabaseHelper myDB;
    ArrayList<String> rem_id, rem_type, rem_amount, rem_date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_rem);

        //Assign variables
        recyclerView = findViewById(R.id.recycleView);
        add = findViewById(R.id.add_button);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Creating Intents
                Intent intent = new Intent (MainRemActivity.this, addRemActivity.class);
                startActivity(intent);
            }
        });

        //Initialize variables
        ImageView left_arrow = findViewById(R.id.left_arrow);
        ImageView check = findViewById(R.id.check);
        ImageView clear = findViewById(R.id.clear);
        TextView title = findViewById(R.id.title);

        left_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Display a toast message when you select back arrow
                Toast.makeText(MainRemActivity.this, "You clicked in left icon" , Toast.LENGTH_SHORT).show();
            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Display a toast message when data inserted to the database
                Toast.makeText(MainRemActivity.this, "Inserted Successfully" , Toast.LENGTH_SHORT).show();
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Display a toast message when data deleted
                Toast.makeText(MainRemActivity.this, "Deleted Successfully" , Toast.LENGTH_SHORT).show();
            }
        });

        title.setText("Manage Reminder");

        myDB = new MyRemDatabaseHelper(MainRemActivity.this);
        rem_id = new ArrayList<>();
        rem_type = new ArrayList<>();
        rem_amount = new ArrayList<>();
        rem_date = new ArrayList<>();

     storeDataInArrays();

        customAdapter = new CustomRemAdapter(MainRemActivity.this,this,rem_id, rem_type, rem_amount, rem_date);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainRemActivity.this));

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
               rem_id.add(cursor.getString(0));
               rem_type.add(cursor.getString(1));
               rem_amount.add(cursor.getString(2));
               rem_date.add(cursor.getString(3));
            }
       }
   }

}