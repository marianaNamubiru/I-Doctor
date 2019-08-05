package com.example.i_doctor.myactivity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.i_doctor.NavigatingActivity;
import com.example.i_doctor.R;
import com.example.i_doctor.helpers.MyApplication;

import java.util.Timer;
import java.util.TimerTask;

public class HomeActivity extends AppCompatActivity {
    float x1,x2,y1,y2;
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (MyApplication.getInstance().getPrefManager().getUser() != null) {
            startActivity(new Intent(this, NavigatingActivity.class));
        }

        setContentView(R.layout.activity_home);

        timer = new Timer();
        timer.schedule(new TimerTask(){

            @Override
            public void run() {
                Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        }, 3000);

    }

    /*public boolean onTouchEvent(MotionEvent touchEvent) {
        switch (touchEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x1 = touchEvent.getX();
                y1 = touchEvent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = touchEvent.getX();
                y2 = touchEvent.getY();
                if (x1 < x2) {
                    Intent i = new Intent(HomeActivity.this, HomeActivity.class);
                    startActivity(i);

                } else if (x1 > x2) {
                    Intent i = new Intent(HomeActivity.this, LoginActivity.class);
                    startActivity(i);
                }


        } return false;
}*/}
