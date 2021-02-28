package com.emerat.emaratproject.model;

public class User {
    private String mName;
    private String mUsername;
    private String mEmail;
    private short mPhone;
    private short mTelephone;
    private String mAddress;
    private String mPassword;
    private String mCountry;
    private String mToken;

    public User() {
    }

    public User(String name,
                String username,
                String email,
                short phone,
                short telephone,
                String address,
                String password,
                String country,
                String token) {
        mName = name;
        mUsername = username;
        mEmail = email;
        mPhone = phone;
        mTelephone = telephone;
        mAddress = address;
        mPassword = password;
        mCountry = country;
        mToken = token;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public short getPhone() {
        return mPhone;
    }

    public void setPhone(short phone) {
        mPhone = phone;
    }

    public short getTelephone() {
        return mTelephone;
    }

    public void setTelephone(short telephone) {
        mTelephone = telephone;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

    public String getCountry() {
        return mCountry;
    }

    public void setCountry(String country) {
        mCountry = country;
    }

    public String getToken() {
        return mToken;
    }

    public void setToken(String token) {
        mToken = token;
    }
}
