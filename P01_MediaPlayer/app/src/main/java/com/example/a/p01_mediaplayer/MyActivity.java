package com.example.a.p01_mediaplayer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;

import java.io.IOException;

public class MyActivity extends AppCompatActivity {

    private static final int SEEKBAR_VALUE = 1;

    MediaPlayer mp;
    SeekBar seekBar;
    String fileName;


    Handler handler = new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            if(msg.what == SEEKBAR_VALUE){
                seekBar.setProgress(msg.arg1);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        Intent intent = getIntent();
        fileName = intent.getStringExtra("fileName");

        Toast.makeText(MyActivity.this, fileName + " 파일을 선택 하셨습니다.", Toast.LENGTH_LONG).show();

        seekBar = (SeekBar) findViewById(R.id.seekbar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser == true){
                    if(mp != null){
                        mp.seekTo(progress);
                    }
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(mp != null){
            mp.stop();
            mp.release();
            mp = null;
        }
    }

    public void onClickStart(View v){

        //String path = Environment.getExternalStorageDirectory()+ "/Download/" + fileName;
        String path = fileName;
        Toast.makeText(MyActivity.this, path + " 파일을 재생을 시작합니다.", Toast.LENGTH_LONG).show();

        mp = new MediaPlayer();


        try {
            mp.setDataSource(path);
            mp.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }

        mp.start();
        seekBar.setMax(mp.getDuration());

        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                while (mp != null){

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if(mp != null) {

                        Message msg = new Message();
                        msg.what = SEEKBAR_VALUE;
                        msg.arg1 = mp.getCurrentPosition();

                        handler.sendMessage(msg);
                    }

                }
            }
        });

        th.start();

    }

    public  void onStopClick(View v){

        if(mp != null){
            mp.stop();
            mp.release();
            mp = null;
        }

    }
}
