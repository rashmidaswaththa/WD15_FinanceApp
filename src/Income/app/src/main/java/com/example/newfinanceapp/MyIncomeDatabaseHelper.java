package com.example.newfinanceapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyIncomeDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "Finance.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "my_income";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NOTE = "income_note";
    private static final String COLUMN_AMOUNT = "income_amount";
    private static final String COLUMN_CATEGORY = "income_category";


    public MyIncomeDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE my_income (_id INTEGER PRIMARY KEY AUTOINCREMENT, income_note TEXT, income_amount REAL , income_category TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public Boolean addIncome(String note, String amount, String category){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("income_note", note);
        cv.put("income_amount", amount);
        cv.put("income_category", category);
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

