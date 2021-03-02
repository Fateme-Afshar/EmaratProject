package com.emerat.emaratproject.viewModel;

import android.text.Editable;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.emerat.emaratproject.model.PostResponse;
import com.emerat.emaratproject.model.User;
import com.emerat.emaratproject.repository.UserRepository;

public class SignInViewModel extends ViewModel{
    private UserRepository mRepository;
    private User mUser=new User();

    private LiveData<PostResponse> mIsPost;

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

    public void onSignBtnClickListener(){
        mRepository.postUser(mUser);
    }

    public User getUser() {
        return mUser;
    }

    public LiveData<PostResponse> getIsPost() {
        return mIsPost;
    }
}
