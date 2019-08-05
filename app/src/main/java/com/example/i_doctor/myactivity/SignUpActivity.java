package com.example.i_doctor.myactivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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


public class SignUpActivity extends AppCompatActivity {
    // Creating EditText.
    EditText username, FirstName,LastName,Password,Password_again, EmailAddress, Address,PhoneContact,Date_of_birth,Country,Hospital;
    // Creating button;
    Button Submit;
    String gender;

    // Creating Volley RequestQueue.
    RequestQueue requestQueue;
    // Create string variable to hold the EditText Value.
    String usernameHolder, FirstNameHolder,LastNameHolder,PasswordHolder,Password_againHolder,
            EmailAddressHolder, AddressHolder,PhoneContactHolder,Date_of_birthHolder,CountryHolder,HospitalHolder ;
    // Creating Progress dialog.
    ProgressDialog progressDialog;
    private RadioGroup Gendergroup;
    private RadioButton rb;
    private TextView link_Login;
    // Storing server url into String variable.
    String HttpUrl = "http://192.168.43.204/idoctor/User-Registration.php";
    Boolean CheckEditText ;


    private static final String TAG = "SignUpActivity";


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
        LastName = findViewById(R.id.LastName);
        Password = findViewById(R.id.Password);
        Password_again = findViewById(R.id.Password_again);
        Gendergroup = findViewById(R.id.Gendergroup);

        // Creating Volley newRequestQueue .
        requestQueue = Volley.newRequestQueue(SignUpActivity.this);

        // Assigning Activity this to progress dialog.
        progressDialog = new ProgressDialog(SignUpActivity.this);

        link_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent register = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(register);

            }
        });
        // Adding click listener to button.
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Gender_string = gender;
                CheckEditTextIsEmptyOrNot();

                if (CheckEditText) {

                    UserRegistration();

                    Intent intent = new Intent(SignUpActivity.this,LoginActivity.class);
                    startActivity(intent);

                } else {

                    Toast.makeText(SignUpActivity.this, "Please fill all form fields.", Toast.LENGTH_LONG).show();

                }

            }
        });
    }
    //Creating UserRegistration() method.
    public void UserRegistration(){
        // Showing progress dialog at user registration time.
        progressDialog.setMessage("Please Wait, We are Inserting Your Data on Server");
        progressDialog.show();

        // Creating string request with post method.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, HttpUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String ServerResponse) {

                        // Hiding the progress dialog after all task complete.
                        progressDialog.dismiss();

                        // Showing Echo Response Message Coming From Server.
                        Toast.makeText(SignUpActivity.this, ServerResponse, Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                        // Hiding the progress dialog after all task complete.
                        progressDialog.dismiss();

                        // Showing error message if something goes wrong.
                        Toast.makeText(SignUpActivity.this, volleyError.toString(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {

                // Creating Map String Params.
                Map<String, String> params = new HashMap<String, String>();

                // Adding All values to Params.
                // The first argument should be same as your MySQL database table columns.
                params.put("FirstName", FirstNameHolder);
                params.put("LastName",LastNameHolder);
                params.put("username", usernameHolder);
                params.put("Country", CountryHolder);
                params.put("PhoneContact", PhoneContactHolder);
                params.put("Date_of_birth", Date_of_birthHolder);
                params.put("EmailAddress", EmailAddressHolder);
                params.put("Gender", gender);
                params.put("Hospital", HospitalHolder);
                params.put("Address", AddressHolder);
                params.put("Password", PasswordHolder);
                params.put("Password_again", Password_againHolder);

                return params;
            }

        };
        // Creating RequestQueue.
        RequestQueue requestQueue = Volley.newRequestQueue(SignUpActivity.this);

// Adding the StringRequest object into requestQueue.
        requestQueue.add(stringRequest);

    }

    //Creating method to check EditText is empty or not .
    public void CheckEditTextIsEmptyOrNot() {

        // Getting values from EditText.
        FirstNameHolder = FirstName.getText().toString().trim();
        LastNameHolder = LastName.getText().toString().trim();
        usernameHolder = username.getText().toString().trim();
        CountryHolder = Country.getText().toString().trim();
        PhoneContactHolder= PhoneContact.getText().toString().trim();
        Date_of_birthHolder= Date_of_birth.getText().toString().trim();
        EmailAddressHolder = EmailAddress.getText().toString().trim();
        HospitalHolder = Hospital.getText().toString().trim();
        AddressHolder = Address.getText().toString().trim();
        PasswordHolder = Password.getText().toString().trim();
        Password_againHolder = Password_again.getText().toString().trim();

        // Checking whether EditText value is empty or not.
        if (TextUtils.isEmpty(FirstNameHolder) || TextUtils.isEmpty(LastNameHolder) || TextUtils.isEmpty(usernameHolder)
                || TextUtils.isEmpty(CountryHolder) || TextUtils.isEmpty(PhoneContactHolder)|| TextUtils.isEmpty(Date_of_birthHolder)
                || TextUtils.isEmpty(gender)|| TextUtils.isEmpty(HospitalHolder) || TextUtils.isEmpty(EmailAddressHolder)|| TextUtils.isEmpty(PasswordHolder)
                || TextUtils.isEmpty(Password_againHolder)) {

            // If any of EditText is empty then set variable value as False.
            CheckEditText = false;

        } else {

            // If any of EditText is filled then set variable value as True.
            CheckEditText = true;
        }

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






                //connection to the server
               /* Functions functions= new Functions();

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

                Intent Loginintent = new Intent(SignUpActivity.this,LoginActivity.class);
                startActivity(Loginintent);*/

                // Show toast message when button is clicked
                //Toast.makeText(getApplicationContext(),"Successfully signedUp",Toast.LENGTH_LONG).show();







       /*timer = new Timer();
       timer.schedule(new TimerTask(){

            @Override
            public void run() {
                Intent intent = new Intent(SignUpActivity.this, SelectionActivity.class);
                startActivity(intent);
                finish();

            }
        }, 5000);*/










