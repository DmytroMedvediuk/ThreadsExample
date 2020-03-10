package com.dmitrym.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        checkDeadLock();

        raceConditionalCheck();
    }


    private void checkDeadLock() {
        final PingPong ping = new PingPong();
        final PingPong pong = new PingPong();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                ping.ping(pong);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                pong.pong(ping);
            }
        });

        t1.start();
        t2.start();
    }

    private void raceConditionalCheck() {
        final RaceCondition.Incrementer incrementer = new RaceCondition.Incrementer();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    incrementer.act();
                }
            }).start();
        }
    }


}
