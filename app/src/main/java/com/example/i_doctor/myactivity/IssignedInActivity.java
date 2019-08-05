package com.example.i_doctor.myactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.i_doctor.NavigatingActivity;
import com.example.i_doctor.R;

public class IssignedInActivity extends AppCompatActivity {

    private TextView txtUsername,link_start;
    private TextView txtEmail;
    private Button btnLogout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issigned_in);

        txtUsername = (TextView) findViewById(R.id.Username);
        txtEmail= (TextView) findViewById(R.id.Email);
        btnLogout = (Button) findViewById(R.id.btnLogout);
        link_start=(TextView)findViewById(R.id.link_start);


        // Receiving value into activity using intent.
        String TempHolder1 = getIntent().getStringExtra("usernameTAG");
        String TempHolder2 = getIntent().getStringExtra("EmailAddressTAG");

        // Setting up received value into TextView.
        txtUsername.setText("User:  " +TempHolder1);
        txtEmail.setText("EmailAddress:  "+TempHolder2);

        // Adding click listener to logout button.
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Showing Echo Response Message Coming From Server.
                Toast.makeText(IssignedInActivity.this, "Logged Out Successfully", Toast.LENGTH_LONG).show();

                // Closing the current activity.
                finish();

                // Redirect to  Login activity after log out.
                Intent intent = new Intent(IssignedInActivity.this, LoginActivity.class);

                startActivity(intent);

            }
        });

        link_start.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IssignedInActivity.this, NavigatingActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}





