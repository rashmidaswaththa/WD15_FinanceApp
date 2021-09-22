package com.example.newfinanceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateExpenseActivity extends AppCompatActivity {


    //views
    private ImageView imageView;
    private ImageButton imageButton;
    private EditText note_text;
    private EditText amount_text;
    private Spinner s1;
    private Spinner s2;

    private String recordId;

    //db helper
    MyDatabaseHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_expense);

        //init views
        imageView = findViewById(R.id.insertImage);
        note_text = findViewById(R.id.addField1_text);
        amount_text = findViewById(R.id.addField2_text);
        s1 = (Spinner) findViewById(R.id.paymethod_list);
        s2 = (Spinner) findViewById(R.id.category_list);
        imageButton = findViewById(R.id.uploadImage_btn);

        //init db helper class
        DB  = new MyDatabaseHelper(this);

        //Tool bar
        ImageView left_arrow = findViewById(R.id.left_arrow);
        ImageView check = findViewById(R.id.check);
        TextView title = findViewById(R.id.title);
        ImageView clear = findViewById(R.id.clear);


        //get record id from adapter through intent
        Intent intent = new Intent();
        recordId = intent.getStringExtra("_id");

        left_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(UpdateExpenseActivity.this, "You clicked in left icon" , Toast.LENGTH_SHORT).show();
            }
        });

        //showRecordDetails();


    }

//    private void showRecordDetails() {
//        //get data
//        String query = "SELECT * FROM expense WHERE  _id =" +recordId+ " ";
//        SQLiteDatabase database = DB.getReadableDatabase();
//        Cursor cursor = database.rawQuery(query, null);
//
//        do{
//            String id = " "+cursor.getString(cursor.getColumnIndex("_id"));
//            String note = ""+cursor.getString(cursor.getColumnIndex("expense_note"));
//            String amount = ""+cursor.getString(cursor.getColumnIndex("expense_amount"));
//            String method = ""+cursor.getString(cursor.getColumnIndex("payment_method"));
//            String category = ""+cursor.getString(cursor.getColumnIndex("expense_category"));
//
//            note_text.setText(note);
//
//            amount_text.setText(amount);
//
//            note_text.setText(note);
//        }while(cursor.moveToNext());
//
//
//
//    }


}