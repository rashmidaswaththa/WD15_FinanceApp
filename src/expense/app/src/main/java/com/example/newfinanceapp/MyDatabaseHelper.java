package com.example.newfinanceapp;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.SyncStateContract;

import androidx.annotation.Nullable;

import java.sql.Blob;
import java.util.ArrayList;


public class MyDatabaseHelper extends SQLiteOpenHelper{
    private Context context;
    private static final String DATABASE_NAME = "Finance.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "expense";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NOTE = "expense_note";
    private static final String COLUMN_IMAGE = "expense_image";
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

        String query = "CREATE TABLE expense(_id INTEGER primary key, expense_note TEXT,expense_image BLOB NOT NULL, expense_amount REAL, payment_method TEXT, expense_category TEXT)";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    public boolean  insertData(String note, byte[] image ,String amount, String payMethod, String category) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("expense_note", note);
        cv.put("expense_image", image);
        cv.put("expense_amount", amount);
        cv.put("payment_method" , payMethod);
        cv.put("expense_category", category);

        long ins = myDB.insert("expense", null, cv);
        if(ins == -1) return false;
        else return true;


    }

    //get all data
    public ArrayList<ExpenseModelRecord> getAllRecords(String filter){


        //query to select records
        String selectQuery;

        if(filter.equals("")){
            //regular query
            selectQuery = "SELECT  * FROM " + TABLE_NAME;
        }else{
            //filter results by filter option provided
            selectQuery = "SELECT  * FROM " + TABLE_NAME + " ORDER BY "+ filter;
        }

        ArrayList<ExpenseModelRecord> recordList = new ArrayList<>();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery , null);
        ExpenseModelRecord modelRecord;

        //looping through all records and add to list
        if(cursor.moveToFirst()){
            do{
                modelRecord = new ExpenseModelRecord();
                //ExpenseModelRecord modelRecord = new ExpenseModelRecord( cursor.getString(cursor.getColumnIndex("_id")), cursor.getString(cursor.getColumnIndex("expense_note")), cursor.getBlob(cursor.getColumnIndex("expense_image")), cursor.getString(cursor.getColumnIndex("expense_amount")), cursor.getString(cursor.getColumnIndex("payment_method")), cursor.getString(cursor.getColumnIndex("expense_category")));
                modelRecord.setId((cursor.getString(0)));
                modelRecord.setNote(cursor.getString(1));
                modelRecord.setImage(cursor.getBlob(2));
                modelRecord.setAmount(cursor.getString(3));
                modelRecord.setPay_method(cursor.getString(4));
                modelRecord.setCategory(cursor.getString(5));
                recordList.add(modelRecord);

            }while (cursor.moveToNext());
        }

        return  recordList;

    }




    //search data
    public ArrayList<ExpenseModelRecord> searchRecords(String query){

        ArrayList<ExpenseModelRecord> recordList = new ArrayList<>();
        //query to select records

        String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE expense_category LIKE '%" + query + "%'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery , null);

        //looping through all records and add to list
        if(cursor.moveToFirst()){
            do{
                ExpenseModelRecord modelRecord = new ExpenseModelRecord();
                modelRecord.setId((cursor.getString(0)));
                modelRecord.setNote(cursor.getString(1));
                modelRecord.setImage(cursor.getBlob(2));
                modelRecord.setAmount(cursor.getString(3));
                modelRecord.setPay_method(cursor.getString(4));
                modelRecord.setCategory(cursor.getString(5));
                //ExpenseModelRecord modelRecord = new ExpenseModelRecord( cursor.getString(cursor.getColumnIndex("_id")), cursor.getString(cursor.getColumnIndex("expense_note")), cursor.getBlob(cursor.getColumnIndex("expense_image")), cursor.getString(cursor.getColumnIndex("expense_amount")), cursor.getString(cursor.getColumnIndex("payment_method")), cursor.getString(cursor.getColumnIndex("expense_category")));
                recordList.add(modelRecord);
            }while (cursor.moveToNext());
        }

        return  recordList;

    }

    //get number of records
    public int getRecordsCount(){
        String countQuery = "SELECT * FROM expense";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery , null);
        int count = cursor.getCount();
        cursor.close();
        return count;

    }
}




