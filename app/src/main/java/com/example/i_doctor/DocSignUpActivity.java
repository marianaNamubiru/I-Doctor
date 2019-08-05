package com.example.i_doctor;

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
import com.example.i_doctor.myactivity.LoginActivity;

import java.util.HashMap;
import java.util.Map;

public class DocSignUpActivity extends AppCompatActivity {
    String gender;
    private RadioGroup Gendergroup;
    // Creating EditText.
    EditText username, FirstName,LastName,Password,Password_again, EmailAddress, Address,PhoneContact,Date_of_birth,Country,
            Hospital,Area_of_Specialization,Licence;
    // Creating button;
    Button Submit;

    // Creating Volley RequestQueue.
    RequestQueue requestQueue;
    // Create string variable to hold the EditText Value.
    String usernameHolder, FirstNameHolder,LastNameHolder,PasswordHolder, EmailAddressHolder, AddressHolder,PhoneContactHolder,
            Date_of_birthHolder,CountryHolder,HospitalHolder,Doctor_Licence_No,Area_of_SpecializationHolder,GenderHolder;
    // Creating Progress dialog.
    ProgressDialog progressDialog;
    private RadioButton rb;
    private TextView link_Login;
    // Storing server url into String variable.
    String HttpUrl = "http://192.168.43.204/idoctor/Doctor-Registration.php";
    Boolean CheckEditText ;

    private static final String TAG = "DocSignUpActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_sign_up);

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
        Area_of_Specialization = findViewById(R.id.Area_of_Specialization);
        Licence = findViewById(R.id.Licence);
        Password_again = findViewById(R.id.Password_again);

        Gendergroup = findViewById(R.id.Gendergroup);

        // Creating Volley newRequestQueue .
                requestQueue = com.android.volley.toolbox.Volley.newRequestQueue(DocSignUpActivity.this);

        // Assigning Activity this to progress dialog.
        progressDialog = new ProgressDialog(DocSignUpActivity.this);

        link_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent register = new Intent(DocSignUpActivity.this, LoginActivity.class);
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

                    Intent intent = new Intent(DocSignUpActivity.this,LoginActivity.class);
                    startActivity(intent);

                } else {

                    Toast.makeText(DocSignUpActivity.this, "Please fill all form fields.", Toast.LENGTH_LONG).show();

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
                        Toast.makeText(DocSignUpActivity.this, ServerResponse, Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                        // Hiding the progress dialog after all task complete.
                        progressDialog.dismiss();

                        // Showing error message if something goes wrong.
                        Toast.makeText(DocSignUpActivity.this, volleyError.toString(), Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() {

                // Creating Map String Params.
                Map<String, String> params = new HashMap<String, String>();

                // Adding All values to Params.
                // The first argument should be same as your MySQL database table columns.
                params.put("FirstName", FirstNameHolder);
                params.put("LastName",LastNameHolder);
                params.put("EmailAddress", EmailAddressHolder);
                params.put("PhoneContact", PhoneContactHolder);
                params.put("Country", CountryHolder);
                params.put("Address", AddressHolder);
                params.put("Date_of_birth", Date_of_birthHolder);
                params.put("username", usernameHolder);
                params.put("Password", PasswordHolder);
                params.put("Gender", gender);
                params.put("Area_of_Specialization", Area_of_SpecializationHolder);
                params.put("Hospital", HospitalHolder);
                params.put("Doctor_Licence No", Doctor_Licence_No);

                return params;
            }

        };
        // Creating RequestQueue.
        RequestQueue requestQueue = Volley.newRequestQueue(DocSignUpActivity.this);

// Adding the StringRequest object into requestQueue.
        requestQueue.add(stringRequest);

    }
    //Creating method to check EditText is empty or not .
    public void CheckEditTextIsEmptyOrNot() {

        // Getting values from EditText.
        FirstNameHolder = FirstName.getText().toString().trim();
        LastNameHolder = LastName.getText().toString().trim();
        EmailAddressHolder = EmailAddress.getText().toString().trim();
        PhoneContactHolder= PhoneContact.getText().toString().trim();
        CountryHolder = Country.getText().toString().trim();
        AddressHolder = Address.getText().toString().trim();
        Date_of_birthHolder= Date_of_birth.getText().toString().trim();
        usernameHolder = username.getText().toString().trim();
        PasswordHolder = Password.getText().toString().trim();
        GenderHolder = gender;
        Area_of_SpecializationHolder = Area_of_Specialization.getText().toString().trim();
        HospitalHolder = Hospital.getText().toString().trim();
        Doctor_Licence_No = Licence.getText().toString().trim();


        // Checking whether EditText value is empty or not.
        if (TextUtils.isEmpty(FirstNameHolder) || TextUtils.isEmpty(LastNameHolder) || TextUtils.isEmpty(usernameHolder)
                || TextUtils.isEmpty(CountryHolder) || TextUtils.isEmpty(PhoneContactHolder)|| TextUtils.isEmpty(EmailAddressHolder)
                || TextUtils.isEmpty(gender)|| TextUtils.isEmpty(HospitalHolder) || TextUtils.isEmpty(EmailAddressHolder)|| TextUtils.isEmpty(PasswordHolder)
                || TextUtils.isEmpty(Doctor_Licence_No)|| TextUtils.isEmpty(Area_of_SpecializationHolder)|| TextUtils.isEmpty(GenderHolder)) {

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
