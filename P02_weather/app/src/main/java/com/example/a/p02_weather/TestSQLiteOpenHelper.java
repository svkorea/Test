package com.example.a.p02_weather;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by a on 2016-04-19.
 */
public class TestSQLiteOpenHelper extends SQLiteOpenHelper {

    public TestSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE weather (id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + " timespan INTEGER, day INTEGER, hour INTEGER, temp INTEGER, wfKor TEXT)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sql = "DROP TABLE if EXISTS weather";
        db.execSQL(sql);

        onCreate(db);
    }
}
