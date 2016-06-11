package com.paintphobia.heri.belajarandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.paintphobia.heri.belajarandroid.login.LoginActivity;

public class MainActivity extends AppCompatActivity {
    private final int DURATION = 4000;
    private Thread mSplashThread;

    public final String URL = "https://muslimsalat.p.mashape.com";

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
                        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
            }
        };
        mSplashThread.start();

    }
}
