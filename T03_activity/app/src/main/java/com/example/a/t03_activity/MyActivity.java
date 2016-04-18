package com.example.a.t03_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
    }

    public void onStartButtonClick(View v){
        Intent intent = new Intent(MyActivity.this, MainActivity.class);
        intent.putExtra("id", "abcd");
        startActivity(intent);
    }
}
