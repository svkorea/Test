package com.example.a.t20_fragment2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onMyClick(View v) {

        FragmentManager fm = getSupportFragmentManager();
        Fragment fr = fm.findFragmentById(R.id.frame);

        switch (v.getId()) {
            case R.id.btnAdd:
                if(fr == null){
                    MyFragment myFragment = new MyFragment();

                    FragmentTransaction tr = fm.beginTransaction();
                    tr.add(R.id.frame, myFragment, "counter");
                    tr.addToBackStack(null);
                    tr.commit();
                }
                break;

            case R.id.btnRemove:
                if(fr != null){
                    FragmentTransaction tr = fm.beginTransaction();
                    tr.remove(fr);
                    tr.commit();
                    fm.popBackStack();
                }
                break;

            case R.id.btnReplace:
                if(fr != null){
                    FragmentTransaction tr = fm.beginTransaction();

                    if(fr.getTag().equals("counter")){
                        TextFragment tf = new TextFragment();
                        tr.replace(R.id.frame, tf, "text");

                    }else{
                        MyFragment mf = new MyFragment();
                        tr.replace(R.id.frame, mf, "counter");

                    }
                    tr.addToBackStack(null);
                    tr.commit();
                }
                break;

            case R.id.btnHide:
                if(fr != null){
                    FragmentTransaction tr = fm.beginTransaction();

                    if(fr.isHidden()){
                        tr.show(fr);
                    }else{
                        tr.hide(fr);
                    }

                    tr.addToBackStack(null);
                    tr.commit();
                }
                break;
        }

    }
}
