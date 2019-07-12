package com.example.i_doctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Selection;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

public class SignUpActivity extends AppCompatActivity {

    EditText username, FirstName,LastName,Password,Password_again, EmailAddress, Address,PhoneContact,Date_of_birth,Country,Hospital;
    Button Submit;
    RadioGroup Gendergroup;
    RadioButton rb;
    TextView link_Login;
    String gender;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        link_Login = findViewById(R.id.link_Login);
        username = findViewById(R.id.username);
        FirstName = findViewById(R.id.FirstName);
        Submit = findViewById(R.id.Submit);
        EmailAddress = findViewById(R.id.EmailAddress);
        Address = findViewById(R.id.Address);
        PhoneContact = findViewById(R.id.PhoneContact);
        Date_of_birth = findViewById(R.id.Date_of_birth);
        Hospital = findViewById(R.id.Hospital);
        Country = findViewById(R.id.Country);
        LastName=findViewById(R.id.LastName);
        Password=findViewById(R.id.Password);
        Password_again=findViewById(R.id.Password_again);
        Gendergroup=findViewById(R.id.Gendergroup);




        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username_string  = username.getText().toString();
                String FastName_string  = FirstName.getText().toString();
                String EmailAddress_string  = EmailAddress.getText().toString();
                String Address_string  = Address.getText().toString();
                String PhoneContact_string  = PhoneContact.getText().toString();
                String Date_of_birth_string = Date_of_birth.getText().toString();
                String Hospital_string  = Hospital.getText().toString();
                String LastName_string  = LastName.getText().toString();
                String Password_string  = Password.getText().toString();
                String Password_again_string  = Password_again.getText().toString();
                String Country_string  = Country.getText().toString();


                if (TextUtils.isEmpty(username_string)){
                    Toast.makeText(SignUpActivity.this, "Fill out the username", Toast.LENGTH_SHORT).show();
                    return;
                }

                //connection to the server
                Functions functions= new Functions();

                String network_address = functions.adress() + "idoctor/sign_up.php?username=" + username_string+ "&password=" + Password_string+ "&FirstName=" + FastName_string
                        +"&LastName=" + LastName_string +"&Country=" + Country_string+"&PhoneContact=" + PhoneContact_string+"&Address="
                        + Address_string+"&EmailAddress=" + EmailAddress_string+"&Password_again=" + Password_again_string
                        +"&Date_of_birth=" + Date_of_birth_string + "&Hospital=" + Hospital_string;

                Log.e("ip", network_address);

                StringRequest request = new StringRequest(network_address, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(SignUpActivity.this, response, Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(SignUpActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });

                RequestQueue requestQueue = Volley.newRequestQueue(SignUpActivity.this);
                requestQueue.add(request);

                /*Intent Loginintent = new Intent(SignUpActivity.this,LoginActivity.class);
                startActivity(Loginintent);*/

                // Show toast message when button is clicked
                //Toast.makeText(getApplicationContext(),"Successfully signedUp",Toast.LENGTH_LONG).show();

            }
        });

        link_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent alreadyintent = new Intent(SignUpActivity.this,LoginActivity.class);
                startActivity(alreadyintent);
            }
        });


       /*timer = new Timer();
       timer.schedule(new TimerTask(){

            @Override
            public void run() {
                Intent intent = new Intent(SignUpActivity.this, SelectionActivity.class);
                startActivity(intent);
                finish();

            }
        }, 5000);*/




    }
    public void rbClick(View v){
        int radiobuttonid = Gendergroup.getCheckedRadioButtonId();


        if (radiobuttonid == R.id.Maleradio){
            gender = "0";
            Toast.makeText(getBaseContext(),"You are male",Toast.LENGTH_LONG).show();
        } else if (radiobuttonid == R.id.Femaleradio){
            gender = "1";
            Toast.makeText(getBaseContext(),"You are female",Toast.LENGTH_LONG).show();
        }
    }
}





