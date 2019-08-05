package com.example.i_doctor.myactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.i_doctor.DocSignUpActivity;
import com.example.i_doctor.R;

import java.util.Timer;


public class SelectionActivity extends AppCompatActivity {
    RadioButton IsDoctor,IsPatient;
    private Button goto_SignUp;
    Timer timer;
    String selected;
    private RadioGroup SignAsRadio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
        IsDoctor = findViewById(R.id.IsDoctor);
        IsPatient = findViewById(R.id.IsPatient);
        goto_SignUp = (Button) findViewById(R.id.goto_SignUp);

        SignAsRadio = findViewById(R.id.SignAsRadio);


        goto_SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent selectedintent = new Intent(SelectionActivity.this, SignUpActivity.class);
                startActivity(selectedintent);

                Toast.makeText(getApplicationContext(), "Successful", Toast.LENGTH_LONG).show();
            }
        });


    }
    public void rbClick(View v){
        int radiobuttonid = SignAsRadio.getCheckedRadioButtonId();


        if (radiobuttonid == R.id.IsDoctor){
            selected = "Doctor";
            Toast.makeText(getBaseContext(),"You are a Doctor",Toast.LENGTH_LONG).show();

            Intent intent = new Intent(SelectionActivity.this, DocSignUpActivity.class);
            startActivity(intent);

        } else if (radiobuttonid == R.id.IsPatient){
            selected = "Doctor";
            Toast.makeText(getBaseContext(),"You are a Patient",Toast.LENGTH_LONG).show();

            Intent intent = new Intent(SelectionActivity.this, SignUpActivity.class);
            startActivity(intent);

        }
    }}

