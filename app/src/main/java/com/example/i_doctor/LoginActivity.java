package com.example.i_doctor;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Selection;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.i_doctor.helpers.Functions;

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
                Intent selectintent = new Intent(LoginActivity.this,SelectionActivity.class);
                startActivity(selectintent);

                Toast.makeText(getApplicationContext(),"Sign up as???",Toast.LENGTH_SHORT).show();
            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username_string  = input_username.getText().toString();
                String password_string  = input_password.getText().toString();


                if (TextUtils.isEmpty(username_string)){
                    Toast.makeText(LoginActivity.this, "please enter your username and password", Toast.LENGTH_SHORT).show();
                    return;
                }

                Functions func =new Functions();
                String network_address = func.adress()+"idoctor/login.php?username=" + username_string + "&password=" + password_string;
                Log.e("ip", network_address);

                StringRequest log = new StringRequest(network_address, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String log) {
                        Toast.makeText(LoginActivity.this, log, Toast.LENGTH_SHORT).show();}
                        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(LoginActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
                });

                RequestQueue logQueue = Volley.newRequestQueue(LoginActivity.this);
                logQueue.add(log);




        /*timer = new Timer();
        timer.schedule(new TimerTask(){

            @Override
            public void run() {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
                finish();

            }
        }, 7000);*/


    }});
    }}





