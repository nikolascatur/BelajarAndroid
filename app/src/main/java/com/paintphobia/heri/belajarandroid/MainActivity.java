package com.paintphobia.heri.belajarandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private final int DURATION = 4000;
    private Thread mSplashThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSplashThread = new Thread(){

            public void run() {
                synchronized (this) {
                    try {
                        wait(DURATION);
                    } catch (InterruptedException e) {

                    } finally {
//                        finish();
//                        Intent intent = new Intent(getBaseContext(), MainActivity.class);
                        //startActivity(intent);
                    }
                }
            }
        };
        mSplashThread.start();

    }
}
