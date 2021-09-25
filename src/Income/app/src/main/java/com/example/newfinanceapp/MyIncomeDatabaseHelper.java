package com.example.newfinanceapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MyIncomeDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "Finance.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "my_income";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NOTE = "income_note";
    private static final String COLUMN_AMOUNT = "income_amount";
    private static final String COLUMN_CATEGORY = "income_category";


    MyIncomeDatabaseHelper(@Nullable Context context) {
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

    Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);

        }
        return cursor;
    }

   void updateData(String row_id, String note, String amount, String category){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("income_note", note);
        cv.put("income_amount", amount);
        cv.put("income_category", category);

        long result = db.update(TABLE_NAME, cv, "_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed to Update.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Successfully Updated!", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteOneRow(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, "_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed to Delete.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Successfully Deleted.", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME);
    }

    public List<Income> getIncome(){

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder gb = new SQLiteQueryBuilder();

        //make sure all is column name in your table
        String[] sqlSelect ={"_id", "income_note", "income_amount", "income_category"};
        String tableName ="my_income";

        gb.setTables(tableName);
        //This will like query : select * from my_income where income_note LIKE %pattern%"
        Cursor cursor = gb.query(db,sqlSelect, "income_category ?",new String[]{"%+category%"}, null, null, null, null);
        List<Income> result = new ArrayList<>();
        if(cursor.moveToFirst())
        {
            do{
                Income income = new Income();
                income.setId(cursor.getInt(cursor.getColumnIndex("_id")));
                income.setNote(cursor.getString(cursor.getColumnIndex("income_note")));
                income.setAmount(cursor.getString(cursor.getColumnIndex("income_amount")));
                income.setCategory(cursor.getString(cursor.getColumnIndex("income_category")));

                result.add(income);
            }while (cursor.moveToNext());
        }
        return result;
    }
}


/*
package com.example.newfinanceapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.Nullable;

class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "Finance.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "my_income";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NOTE = "income_note";
    private static final String COLUMN_AMOUNT = "income_amount";
    private static final String COLUMN_CATEGORY = "income_category";


    MyDatabaseHelper(@Nullable Context context) {
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

    Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    void updateData(String row_id, String note, String amount, String category){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("income_note", note);
        cv.put("income_amount", amount);
        cv.put("income_category", category);

        long result = db.update(TABLE_NAME, cv, "_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Updated Successfully!", Toast.LENGTH_SHORT).show();
        }

    }

    void deleteOneRow(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, "_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed to Delete.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Successfully Deleted.", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME);
    }

}
*/

