package com.emerat.emaratproject.viewModel;

import android.app.Application;
import android.text.Editable;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.emerat.emaratproject.model.User;
import com.emerat.emaratproject.repository.UserRepository;
import com.emerat.emaratproject.sharePref.EmaratProjectSharePref;

public class ProfileViewModel extends AndroidViewModel {
    private UserRepository mUserRepository;
    private User mUser;

    private LiveData<Boolean> mIsEditUser;

    public ProfileViewModel(@NonNull Application application,UserRepository userRepository) {
        super(application);
        mUserRepository=userRepository;
        mIsEditUser=userRepository.resultEdit();
        mUser=EmaratProjectSharePref.getUser(getApplication());
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
        mUser.setCountryId(countryCode);
    }

    public void setCityId(String cityId){
        mUser.setCityId(cityId);
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

    public void onEditBtnClickListener(){
        mUserRepository.editUser(mUser);
    }

    public LiveData<Boolean> getIsEditUser() {
        return mUserRepository.resultEdit();
    }

    public User getUser(){
       return mUser;
    }
}
