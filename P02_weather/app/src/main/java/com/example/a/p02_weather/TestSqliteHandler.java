package com.example.a.p02_weather;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by a on 2016-04-19.
 */
public class TestSqliteHandler {

    TestSQLiteOpenHelper helper;

    SQLiteDatabase db;

    public TestSqliteHandler(Context context){
        helper = new TestSQLiteOpenHelper(context, "weather", null, 1);


    }

    public void insertOrUpdate(int timespan, int day, int hour, float temp, String wfKor){

        boolean isAlready = false;

        //기존데이터가 있는지 체크
        db = helper.getReadableDatabase();
        //Cursor c = db.query("weather", null, "timespan = ?", new String[]{String.valueOf(timespan)}, null, null, null);
        String sql = "select * from weather where timespan =" + timespan;
        Cursor c = db.rawQuery(sql, null);

        int dbTimeSpan=0;

        //db.insert("weather", null, values); //insert Test

        while(c.moveToNext()){
            dbTimeSpan = c.getInt(c.getColumnIndex("timespan"));

            if(timespan == dbTimeSpan){
                //현재 timespan이 있으면 update
                isAlready = true;
                //Log.d("SQLite", "TIMESPAN : " + timespan + " 은 이미 존재함.");
            }
        }

        ContentValues values = new ContentValues();

        values.put("timespan",timespan);
        values.put("day",day);
        values.put("hour",hour);
        values.put("temp",temp);
        values.put("wfKor",wfKor);

        db = helper.getWritableDatabase();



        if(isAlready) {
            db.update("weather", values, "timespan = ?", new String[]{String.valueOf(timespan)});
            Log.d("SQLite", "TIMESPAN : " + timespan + " 은 존재함, Update 처리");
        }
        else {
            db.insert("weather", null, values);
            Log.d("SQLite", "TIMESPAN : " + timespan + " 은 존재하지 않음, Insert 처리");
        }


    }

    public void delete(String name){
        //db = helper.getWritableDatabase();
        //db.delete("weather", "name = ?", new String[]{name});
    }

    public void update(int day, int hour, float temp, String wfKor){
        db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("temp", temp);
        values.put("wfKor", wfKor);


        db.update("weather", values, "day = ? | hour = ?", new String[]{String.valueOf(day), String.valueOf(hour)});
    }

    public void selectAll(){
        db = helper.getReadableDatabase();
        Cursor c = db.query("weather", null, null, null, null, null, null);

        while(c.moveToNext()){
            int timespan = c.getInt(c.getColumnIndex("timespan"));
            int id = c.getInt(c.getColumnIndex("id"));
            int day = c.getInt(c.getColumnIndex("day"));
            int hour = c.getInt(c.getColumnIndex("hour"));
            float temp = c.getInt(c.getColumnIndex("temp"));
            String wfKor = c.getString(c.getColumnIndex("wfKor"));


            Log.d("SQLite", "timespan" + timespan + "id : " + id + " day : " + day + " hour : " + hour + " temp : " + temp + "wfKor" + wfKor);
        }
    }
}
