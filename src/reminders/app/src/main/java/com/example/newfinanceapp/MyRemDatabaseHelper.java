package com.example.newfinanceapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyRemDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "Finance.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "Reminder";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_TYPE = "Reminder_type";
    private static final String COLUMN_AMOUNT = "Reminder_amount";
    private static final String COLUMN_DATE = "Reminder_due_date";


    public MyRemDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE Reminder (_id INTEGER PRIMARY KEY AUTOINCREMENT, Reminder_type TEXT, Reminder_amount REAL , Reminder_due_date TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public Boolean addReminder(String Rtype, String Ramount, String Rdate){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("Reminder_type", Rtype);
        cv.put("Reminder_amount", Ramount);
        cv.put("Reminder_due_date", Rdate);
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

