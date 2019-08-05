package com.example.i_doctor.helpers;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class MyPreferenceManager {
    private String TAG = MyPreferenceManager.class.getSimpleName();

    // Shared Preferences
    SharedPreferences pref;

    // Editor for Shared preferences
    SharedPreferences.Editor editor;

    // Context
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Sharedpref file title
    private static final String PREF_NAME = "androidhive_gcm";

    // All Shared Preferences Keys
    private static final String KEY_USER_ID = "user_id";
    private static final String KEY_FIRSTNAME = "FirstName";
    private static final String KEY_LASTNAME = "LastName";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_COUNTRY = "Country";
    private static final String KEY_PHONECONTACT = "PhoneContact";
    private static final String KEY_Date_of_birth = "Date_of_birth";
    private static final String KEY_EMAILADDRESS = "EmailAddress";
    private static final String KEY_GENDER = "Gender";
    private static final String KEY_HOSPITAL = "Hospital";
    private static final String KEY_ADDRESS = "Address";


    // Constructor
    public MyPreferenceManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }


    public void storeUser(User user) {
        editor.putString(KEY_USER_ID, user.getId());
        editor.putString(KEY_FIRSTNAME, user.getFirstName());
        editor.putString(KEY_LASTNAME, user.getLastName());
        editor.putString(KEY_USERNAME, user.getusername());
        editor.putString(KEY_COUNTRY, user.getCountry());
        editor.putString(KEY_PHONECONTACT, user.getPhoneContact());
        editor.putString(KEY_Date_of_birth, user.getDate_of_birth());
        editor.putString(KEY_EMAILADDRESS, user.getEmailAddress());
        editor.putString(KEY_GENDER, user.getGender());
        editor.putString(KEY_HOSPITAL, user.getHospital());
        editor.putString(KEY_ADDRESS, user.getAddress());
        editor.commit();

        Log.e(TAG, "User is stored in shared preferences. " + user.getFirstName() + ", " + user.getLastName()
                + "," + user.getusername()+ "," + user.getCountry()+ "," + user.getPhoneContact() + "," + user.getDate_of_birth()
                + "," +user.getEmailAddress()+ "," +user.getGender() + "," + user.getHospital() + "," + user.getAddress()  );
    }

    public User getUser() {
        if (pref.getString(KEY_USER_ID, null) != null) {
            String id, FirstName, LastName, username,Country,PhoneContact,Date_of_birth,EmailAddress,Gender,
            Hospital,Address;
            id = pref.getString(KEY_USER_ID, null);
            FirstName = pref.getString(KEY_FIRSTNAME, null);
            LastName = pref.getString(KEY_LASTNAME, null);
            username = pref.getString(KEY_USERNAME, null);
            Country =  pref.getString(KEY_COUNTRY, null);
            PhoneContact =  pref.getString(KEY_PHONECONTACT, null);
            Date_of_birth =  pref.getString(KEY_Date_of_birth, null);
            EmailAddress =  pref.getString(KEY_EMAILADDRESS, null);
            Gender =  pref.getString(KEY_GENDER, null);
            Hospital =  pref.getString(KEY_HOSPITAL, null);
            Address =  pref.getString(KEY_ADDRESS, null);



            User user = new User(id, FirstName, LastName,username,Country,PhoneContact,Date_of_birth,EmailAddress,Gender,Hospital,Address);
            return user;
        }
        return null;
    }


    public void clear() {
        editor.clear();
        editor.commit();
    }
}
