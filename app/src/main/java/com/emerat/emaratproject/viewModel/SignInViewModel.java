package com.emerat.emaratproject.viewModel;

import android.text.Editable;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.emerat.emaratproject.di.ApplicationContainer;
import com.emerat.emaratproject.model.User;
import com.emerat.emaratproject.repository.CountryRepository;
import com.emerat.emaratproject.repository.UserRepository;

public class SignInViewModel extends ViewModel{
    private UserRepository mRepository;
    private User mUser=new User();

    private LiveData<Boolean> mIsPost;

    public SignInViewModel(UserRepository repository) {
        mRepository = repository;
        mIsPost=mRepository.resultPost();
    }

    public void afterTextChangeName(Editable editable) {
        mUser.setName(editable.toString());
    }

    public void afterTextChangeUsername(Editable editable){
        mUser.setUsername(editable.toString());
    }

    public void afterTextChangePhone(Editable editable){
        mUser.setPhone(editable.toString());
    }

    public void afterTextChangeTelephone(Editable editable){
        mUser.setTelephone(editable.toString());
    }

    public void setCountryCode(String countryCode){
        mUser.setCountry(countryCode);
    }

    public void setCity(String city){
        mUser.setCountry(city);
    }

    public void afterTextChangeAddress(Editable editable){
        mUser.setAddress(editable.toString());
    }

    public void afterTextChangeEmail(Editable editable){
        mUser.setEmail(editable.toString());
    }

    public void afterTextChangePassword(Editable editable){
        mUser.setPassword(editable.toString());
    }

    private void postUser(){
        mRepository.postUser(mUser);
    }

    public void onSignBtnClickListener(){
        postUser();
    }

    public LiveData<Boolean> getIsPost() {
        return mIsPost;
    }
}
