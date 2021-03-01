package com.emerat.emaratproject.model;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("name")
    private String mName;
    @SerializedName("userName")
    private String mUsername;
    @SerializedName("email")
    private String mEmail;
    @SerializedName("phone")
    private String mPhone;
    @SerializedName("telephone")
    private String mTelephone;
    @SerializedName("address")
    private String mAddress;
    @SerializedName("password")
    private String mPassword;
    @SerializedName("country")
    private String mCountryId;

    @SerializedName("city")
    private String mCityId;

    public User() {
    }

    public User(String name, String username, String email, String phone, String telephone, String address, String password, String countryId, String token) {
        mName = name;
        mUsername = username;
        mEmail = email;
        mPhone = phone;
        mTelephone = telephone;
        mAddress = address;
        mPassword = password;
        mCountryId = countryId;
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

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String phone) {
        mPhone = phone;
    }

    public String getTelephone() {
        return mTelephone;
    }

    public void setTelephone(String telephone) {
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

    public String getCountryId() {
        return mCountryId;
    }

    public void setCountryId(String countryId) {
        mCountryId = countryId;
    }

    public String getCityId() {
        return mCityId;
    }

    public void setCityId(String cityId) {
        mCityId = cityId;
    }
}
