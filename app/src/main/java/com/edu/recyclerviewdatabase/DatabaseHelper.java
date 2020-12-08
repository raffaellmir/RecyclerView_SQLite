package com.edu.recyclerviewdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private Context context;

    private static final String DATABASE_NAME = "dictionary.db";
    static final String TABLE_NAME = "contacts";

    private static final int DATABASE_VERSION = 1;
    private static final String KEY_ID = "_id";
    private static final String KEY_WORD = "word";
    private static final String KEY_MEM_LEVEL = "word_level_mem";
    private static final String KEY_IS_FAV = "is_favourite";
    private static final String KEY_IS_BOUGHT = "is_bought";

    private static final String DROP_TABLE = "DROP TABLE IF EXISTS ";
    private static final String CREATE_TABLE = "CREATE TABLE "+ TABLE_NAME+
            " ("+ KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
            KEY_WORD + " TEXT, " +
            KEY_MEM_LEVEL + " INTEGER, " +
            KEY_IS_FAV + " INTEGER, " +
            KEY_IS_BOUGHT + " INTEGER);";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE + TABLE_NAME);
        onCreate(db);
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

    void updateData(String row_id, String word, int word_level_mem, boolean is_favourite, boolean is_bought){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_WORD, word);
        cv.put(KEY_MEM_LEVEL, word_level_mem);
        cv.put(KEY_IS_FAV, is_favourite);
        cv.put(KEY_IS_BOUGHT, is_bought);

        long result = db.update(TABLE_NAME, cv, "_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Updated Successfully!", Toast.LENGTH_SHORT).show();
        }

    }
}
