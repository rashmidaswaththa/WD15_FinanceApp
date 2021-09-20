package com.example.newfinanceapp;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

import java.sql.Blob;


public class MyDatabaseHelper extends SQLiteOpenHelper{
    private Context context;
    private static final String DATABASE_NAME = "Finance.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "expense";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NOTE = "expense_note";
    private static final String COLUMN_AMOUNT = "expense_amount";
    private static final String COLUMN_METHOD = "payment_method";
    private static final String COLUMN_CATEGORY = "expense_category";
    //private static final String COLUMN_IMAGE = "image";



    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE expense(_id INTEGER primary key, expense_note TEXT, expense_amount REAL, payment_method TEXT, expense_category TEXT)";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    public boolean  insertData(String note, String amount, String payMethod, String category) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("expense_note", note);
        cv.put("expense_amount", amount);
        cv.put("payment_method" , payMethod);
        cv.put("expense_category", category);

        long ins = myDB.insert("expense", null, cv);
        if(ins == -1) return false;
        else return true;


    }
}
