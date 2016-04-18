package com.example.a.t01_widget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget);

        CheckBox myCheckBox = (CheckBox) findViewById(R.id.myCheckBox);
        myCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                Toast.makeText(MainActivity.this, "Checkbox : " + b, Toast.LENGTH_LONG).show();
            }
        });

        RadioGroup myGroup = (RadioGroup) findViewById(R.id.myRadioGroup);

        myGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
               @Override
               public void onCheckedChanged(RadioGroup group, int i) {

                   String str = "";

                 switch (i){
                     case R.id.radio1:
                         str = "radio 1 selected";
                         break;

                     case R.id.radio2:
                         str = "radio 2 selected";
                         break;

                     case R.id.radio3:
                         str = "radio 3 selected";
                         break;
                 }
                   Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
               }
           }


        );

        final EditText myEdit = (EditText)findViewById(R.id.myEditText);

        Button btn = (Button) findViewById(R.id.btnMyBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = myEdit.getText().toString();
                Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
                myEdit.setText("");
            }
        });




    }
}
