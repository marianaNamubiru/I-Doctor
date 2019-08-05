package com.example.i_doctor.myactivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.i_doctor.R;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

public class LoginActivity extends AppCompatActivity {

    TextView  link_register;
    Timer timer;
    // Creating EditText.
    EditText input_username, input_password;
    // Creating button;
    Button Login;
    // Creating Volley RequestQueue.
    RequestQueue requestQueue;
    // Create string variable to hold the EditText Value.
    String usernameHolder, PasswordHolder;
    // Creating Progress dialog.
    ProgressDialog progressDialog;
    // Storing server url into String variable.
    String HttpUrl ="http://192.168.43.204/idoctor//user_login.php";
    Boolean CheckEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);


        Login = (Button) findViewById(R.id.Login);
        link_register = (TextView) findViewById(R.id.link_register);
        input_password = (EditText) findViewById(R.id.input_password);
        input_username = (EditText) findViewById(R.id.input_username);

        // Creating Volley newRequestQueue .
        requestQueue = Volley.newRequestQueue(LoginActivity.this);

        // Assigning Activity this to progress dialog.
        progressDialog = new ProgressDialog(LoginActivity.this);


        link_register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SelectionActivity.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), "Sign up as???", Toast.LENGTH_SHORT).show();
            }
        });


        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username_string = input_username.getText().toString().trim();
                String password_string = input_password.getText().toString().trim();

                CheckEditTextIsEmptyOrNot();

                if (CheckEditText) {

                    UserLogin();

                } else {

                    Toast.makeText(LoginActivity.this, "Please fill all form fields.", Toast.LENGTH_LONG).show();

                }

            }
        });
    }
    // Creating user login function.
    public void UserLogin() {

        // Showing progress dialog at user registration time.
        progressDialog.setMessage("Please Wait");
        progressDialog.show();

        // Creating string request with post method.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, HttpUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String ServerResponse) {

                        // Hiding the progress dialog after all task complete.
                        progressDialog.dismiss();

                        // Matching server responce message to our text.
                        if(ServerResponse.contains("1")) {

                            // If response matched then show the toast.
                            Toast.makeText(LoginActivity.this, "Logged In Successfully", Toast.LENGTH_LONG).show();


                            // Opening the user profile activity using intent.
                            Intent intent = new Intent(LoginActivity.this, IssignedInActivity.class);

                            // Sending Username to another activity using intent.
                            intent.putExtra("usernameTAG", usernameHolder);
                            startActivity(intent);
                        }
                        else {

                            // Showing Echo Response Message Coming From Server.
                            Toast.makeText(LoginActivity.this, ServerResponse, Toast.LENGTH_LONG).show();

                        }


                    }},new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

                // Hiding the progress dialog after all task complete.
                progressDialog.dismiss();

                // Showing error message if something goes wrong.
                Toast.makeText(LoginActivity.this, volleyError.toString(), Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {

                // Creating Map String Params.
                Map<String, String> params = new HashMap<String, String>();

                // Adding All values to Params.
                // The first argument should be same sa your MySQL database table columns.
                params.put("username", usernameHolder);
                params.put("Password", PasswordHolder);
                return params;
            }

        };
        // Creating RequestQueue.
        RequestQueue requestQueue = Volley.newRequestQueue(LoginActivity.this);

        // Adding the StringRequest object into requestQueue.
        requestQueue.add(stringRequest);

    }


    public void CheckEditTextIsEmptyOrNot() {

        // Getting values from EditText.
        usernameHolder = input_username.getText().toString().trim();
        PasswordHolder = input_password.getText().toString().trim();

        // Checking whether EditText value is empty or not.
        if (TextUtils.isEmpty(usernameHolder) || TextUtils.isEmpty(PasswordHolder)) {

            // If any of EditText is empty then set variable value as False.
            CheckEditText = false;

        } else {

            // If any of EditText is filled then set variable value as True.
            CheckEditText = true;
        }
    }


               /* Functions func =new Functions();
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
                });*/

    // RequestQueue logQueue = Volley.newRequestQueue(LoginActivity.this);
    // logQueue.add(log);




        /*timer = new Timer();
        timer.schedule(new TimerTask(){

            @Override
            public void run() {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
                finish();

            }
        }, 7000);*/

}






