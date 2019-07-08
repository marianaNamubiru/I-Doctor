package com.example.i_doctor;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Selection;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class LoginActivity extends AppCompatActivity {

    Timer timer;
    EditText input_username, input_password;
    TextView password,username,link_register;
    Button Login;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        username = (TextView)findViewById(R.id.username);
        password = (TextView)findViewById(R.id.password);
        Login = (Button)findViewById(R.id.Login);
        link_register = (TextView)findViewById(R.id.link_register);
        input_password = (EditText)findViewById(R.id.input_password);
        input_username = (EditText)findViewById(R.id.input_username);

        link_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Registerintent = new Intent(LoginActivity.this,SelectionActivity.class);
                startActivity(Registerintent);

                Toast.makeText(getApplicationContext(),"Sign up as???",Toast.LENGTH_LONG).show();
            }
        });


        /*timer = new Timer();
        timer.schedule(new TimerTask(){

            @Override
            public void run() {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
                finish();

            }
        }, 7000);*/


    }}





