package com.royle.nofix;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


public class quicksupport extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mxplayer);




        Thread timerThread = new Thread() {
            public void run() {
                try {
                    sleep(20000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(quicksupport.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        };
        timerThread.start();

    }

}

