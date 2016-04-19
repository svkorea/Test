package com.example.a.t09_preferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences pref = getSharedPreferences("MySettings", 0); //MODE_PRIVATE
        String value = pref.getString("name" , "NO DATA");
        Toast.makeText(this, value, Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences pref = getSharedPreferences("MySettings", 0);
        SharedPreferences.Editor editor = pref.edit();

        EditText editText = (EditText) findViewById(R.id.editText);
        String value = editText.getText().toString();

        editor.putString("name", value);
        editor.commit();

    }
}
