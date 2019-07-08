package com.example.i_doctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Selection;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class SignUpActivity extends AppCompatActivity {
    EditText username, FirstName, EmailAddress, Address,PhoneContact,Date_of_birth,Country,Hospital;
    Button Submit;
    Timer timer;
    TextView link_Login;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Username = "usernameKey";
    public static final String firstname = "firstnameKey";
    public static final String email = "emailKey";
    public static final String address = "addressKey";
    public static final String phonecontant = "contactKey";
    public static final String dateofbirth = "dateKey";
    public static final String country = "countryKey";
    public static final String hospital = "hospitalKey";

    SharedPreferences sharedpreferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        link_Login = findViewById(R.id.link_Login);
        username = findViewById(R.id.username);
        FirstName = findViewById(R.id.LastName);
        Submit = findViewById(R.id.Submit);
        EmailAddress = findViewById(R.id.EmailAddress);
        Address = findViewById(R.id.Address);
        PhoneContact = findViewById(R.id.PhoneContact);
        Date_of_birth = findViewById(R.id.Date_of_birth);
        Hospital = findViewById(R.id.Hospital);
        Country = findViewById(R.id.Country);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String u  = username.getText().toString();
                String F  = FirstName.getText().toString();
                String E  = EmailAddress.getText().toString();
                String A  = Address.getText().toString();
                String P  = PhoneContact.getText().toString();
                String D  = Date_of_birth.getText().toString();
                String H  = Hospital.getText().toString();
                String C  = Country.getText().toString();


                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString(Username, u);
                editor.putString(firstname, F);
                editor.putString(email, E);
                editor.putString(address, A);
                editor.putString(phonecontant, P);
                editor.putString(dateofbirth, D);
                editor.putString(country, C);
                editor.putString(hospital, H);
                editor.apply();

                Intent Loginintent = new Intent(SignUpActivity.this,LoginActivity.class);
                startActivity(Loginintent);
                // Show toast message when button is clicked
                Toast.makeText(getApplicationContext(),"Successfully signedUp",Toast.LENGTH_LONG).show();

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
        }



