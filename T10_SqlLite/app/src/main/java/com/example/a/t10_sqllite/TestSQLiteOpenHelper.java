package com.example.a.t10_sqllite;

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

        String sql = "CREATE TABLE student (id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + " name TEXT, age INTEGER, address TEXT)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sql = "DROP TABLE if EXISTS student";
        db.execSQL(sql);

        onCreate(db);
    }
}
