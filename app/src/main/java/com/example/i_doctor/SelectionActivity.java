package com.example.i_doctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Selection;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;


public class SelectionActivity extends AppCompatActivity {
    RadioButton IsDoctor,IsPatient,IsAdmin;

    private Button goto_SignUp;
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);


        IsDoctor = findViewById(R.id.IsDoctor);
        IsPatient = findViewById(R.id.IsPatient);
        IsAdmin = findViewById(R.id.IsAdmin);
        goto_SignUp = (Button) findViewById(R.id.goto_SignUp);


        goto_SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent selectedintent = new Intent(SelectionActivity.this,SignUpActivity.class);
                startActivity(selectedintent);

                Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_LONG).show();
            }
        });

        /*        timer = new Timer();
        timer.schedule(new TimerTask(){


            @Override
            public void run() {
                Intent intent = new Intent(SelectionActivity.this, SignUpActivity.class);
                startActivity(intent);
                finish();

            }
        }, 6000);*/




    }




        }

