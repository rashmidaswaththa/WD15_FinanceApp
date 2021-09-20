package com.example.newfinanceapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "Finance.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "my_income";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_GOAL_NAME = "goal_name";
    private static final String COLUMN_GOAL_AMOUNT = "goal_amount";
    private static final String COLUMN_GOAL_DESCRIPTION = "goal_description";


    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE my_income (_id INTEGER PRIMARY KEY AUTOINCREMENT, goal_name TEXT, goal_amount REAL , goal_description TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public Boolean addGoal(String goalName, String goalAmount, String goalDes){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("goal_name", goalName);
        cv.put("goal_amount", goalAmount);
        cv.put("goal_description", goalDes);
        long result = db.insert(TABLE_NAME, null, cv);
        if(result == -1){
            return false;
        }else{
            return true;
        }


    }

//    Cursor readAllData(){
//        String query = "SELECT * FROM " + TABLE_NAME;
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        Cursor cursor = null;
//        if(db != null){
//            cursor = db.rawQuery(query, null);
//
//        }
//        return cursor;
//    }
}

