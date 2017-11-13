package com.example.hareen.mytaskplanner;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ibrahim on 11/12/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";
    private static final String TABLE_NAME = "task_table";
    private static final String COL0 = "ID";
    private static final String COL1 = "task";
    private static final String COL2 = "task_date";
    private static final String COL3 = "task_time";
    public DatabaseHelper(Context context){
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL1 + " TEXT," + COL2 + " TEXT," + COL3 + " TEXT)";
         db.execSQL(createTable);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
         db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
         onCreate(db);
    }

    public boolean addData(Task task){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, task.task);
        contentValues.put(COL2, task.date);
        contentValues.put(COL3, task.completionTime);


        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1 ){
            return false;
        } else {
            return true;
        }

    }
    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME ;
        Cursor data = db.rawQuery(query,null);
        return data;

    }
}












