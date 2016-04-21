package com.example.a.t21_notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    NotificationManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);


    }

    public void onBtnClick(View v){

        Toast.makeText(this, "notification test", Toast.LENGTH_SHORT).show();
/*
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }).start();
  */
        v.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(MainActivity.this, NotiActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                PendingIntent pIntent = PendingIntent.getActivity(MainActivity.this,
                        0, intent, 0);

                Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.penguins);
                Notification notification = new NotificationCompat.Builder(MainActivity.this)
                        .setContentTitle("TITLE")
                        .setContentText("TEXT")
                        .setSubText("SUB TEXT")
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setLargeIcon(bm)
                        .setAutoCancel(true)
                        .setContentIntent(pIntent)
                        .build();
                manager.notify(1234, notification);
            }
        }, 5000);

    }
}
