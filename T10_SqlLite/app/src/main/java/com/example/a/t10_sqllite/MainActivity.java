package com.example.a.t10_sqllite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TestSqliteHandler sqliteHandler = new TestSqliteHandler(this);
        sqliteHandler.insert("kim", 20, "seoul");
        sqliteHandler.insert("가나다", 21, "인천");

        sqliteHandler.selectAll();

        sqliteHandler.delete("kim");

        sqliteHandler.selectAll();
    }
}
