package com.example.newfinanceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainRemActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton add;

    MyRemDatabaseHelper myDB;
    //ArrayList<String> income_id, income_note, income_amount, income_category;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_rem);

        recyclerView = findViewById(R.id.recycleView);
        add = findViewById(R.id.add_button);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (MainRemActivity.this, addRemActivity.class);
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
                Toast.makeText(MainRemActivity.this, "You clicked in left icon" , Toast.LENGTH_SHORT).show();
            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainRemActivity.this, "Inserted Successfully" , Toast.LENGTH_SHORT).show();
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainRemActivity.this, "Deleted Successfully" , Toast.LENGTH_SHORT).show();
            }
        });

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

}