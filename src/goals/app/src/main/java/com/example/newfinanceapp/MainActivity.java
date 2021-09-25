package com.example.newfinanceapp;

<<<<<<< HEAD
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
=======
import androidx.appcompat.app.AppCompatActivity;
>>>>>>> 04e8260 (Add all files again)
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

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton add;

    MyDatabaseHelper myDB;
<<<<<<< HEAD
    ArrayList<String> goal_id, goal_name, goal_amount, goal_description;
    CustomAdapter customAdapter;
=======
    //ArrayList<String> income_id, income_note, income_amount, income_category;

>>>>>>> 04e8260 (Add all files again)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleView);
        add = findViewById(R.id.add_button);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (MainActivity.this, addActivity.class);
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
                Toast.makeText(MainActivity.this, "You clicked in left icon" , Toast.LENGTH_SHORT).show();
            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Inserted Successfully" , Toast.LENGTH_SHORT).show();
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Deleted Successfully" , Toast.LENGTH_SHORT).show();
            }
        });

<<<<<<< HEAD
        title.setText("Manage Goals");

        myDB = new MyDatabaseHelper(MainActivity.this);
        goal_id = new ArrayList<>();
        goal_name = new ArrayList<>();
        goal_amount = new ArrayList<>();
        goal_description = new ArrayList<>();

        storeDataInArrays();

        customAdapter = new CustomAdapter(MainActivity.this,this,goal_id, goal_name, goal_amount, goal_description);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1)
        {
            recreate();
        }
    }

    void storeDataInArrays(){
        Cursor cursor = myDB.readAllData();
        if(cursor.getCount() == 0){
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                goal_id.add(cursor.getString(0));
                goal_name.add(cursor.getString(1));
                goal_amount.add(cursor.getString(2));
                goal_description.add(cursor.getString(3));
            }
        }
    }
=======
        title.setText("Manage Income");

//        myDB = new MyDatabaseHelper(MainActivity.this);
//        income_id = new ArrayList<>();
//        income_note = new ArrayList<>();
//        income_amount = new ArrayList<>();
//        income_category = new ArrayList<>();
//
//        storeDataInArrays();
    }

//    void storeDataInArrays(){
//        Cursor cursor = myDB.readAllData();
//        if(cursor.getCount() == 0){
//            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
//        }else{
//            while (cursor.moveToNext()){
//                income_id.add(cursor.getString(0));
//                income_note.add(cursor.getString(1));
//                income_amount.add(cursor.getString(2));
//                income_category.add(cursor.getString(3));
//            }
//        }
//    }
>>>>>>> 04e8260 (Add all files again)

}