package com.puzzle.puzzletrack;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DungeonDatabase extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "PuzzleStorage.db";
    public static final String TABLE_NAME = "Dungeon";
    public static final String NAME = "Name";

    public DungeonDatabase(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Will execute query that is passed to the function
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, Name Text) " );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    public boolean insertData(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        // put obtains two values
        // 1) The column name
        // 2) The value that will be inserted into the specified column
        cv.put(NAME, name);
        // Will return -1 if an error occurred, otherwise will return the row ID (or inserted value)
        long result = db.insert(TABLE_NAME, null, cv);
        // Just to check whether the data was successfully inserted
        if(result == -1){
            return false;
        }
        else{
            return true;
        }
    }
}
