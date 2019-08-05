package com.example.i_doctor.helpers;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;


public class User implements Parcelable {
    @SerializedName("user_id")
    String id;
    @SerializedName("FirstName")
    String firstName;
    @SerializedName("LastName")
    String lastName;
    @SerializedName("username")
    String username;
    @SerializedName("Country")
    String country;
    @SerializedName("PhoneContact")
    String phoneContact;
    @SerializedName("Date_of_birth")
    String date_of_birth;
    @SerializedName("EmailAddress")
    String emailAddress;
    @SerializedName("Gender")
    String gender;
    @SerializedName("Hospital")
    String hospital;
    @SerializedName("Address")
    String address;


    public User(){
    }

    public User(String id, String firstName, String lastName, String username, String country, String phoneContact, String date_of_birth,
                String emailAddress, String gender, String hospital, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.country = country;
        this.phoneContact = phoneContact;
        this.date_of_birth = date_of_birth;
        this.emailAddress = emailAddress;
        this.gender = gender;
        this.hospital = hospital;
        this.address = address;
    }

    protected User(Parcel in) {
        id = in.readString();
        firstName = in.readString();
        lastName = in.readString();
        username = in.readString();
        country = in.readString();
        phoneContact = in.readString();
        date_of_birth = in.readString();
        emailAddress = in.readString();
        gender = in.readString();
        hospital = in.readString();
        address = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(firstName);
        dest.writeString(lastName);
        dest.writeString(username);
        dest.writeString(country);
        dest.writeString(phoneContact);
        dest.writeString(date_of_birth);
        dest.writeString(emailAddress);
        dest.writeString(gender);
        dest.writeString(hospital);
        dest.writeString(address);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getusername() {
        return username;
    }

    public void setusername(String mobile) {
        this.username = username;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) { this.country = country; }

    public String getPhoneContact() {
        return phoneContact;
    }

    public void setPhoneContact(String phoneContact) {
        this.phoneContact = phoneContact;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



}
