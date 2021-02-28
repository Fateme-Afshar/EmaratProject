package com.emerat.emaratproject.viewModel;

import android.text.Editable;

import androidx.lifecycle.ViewModel;

import com.emerat.emaratproject.factory.Factory;
import com.emerat.emaratproject.model.User;
import com.emerat.emaratproject.repository.UserRepository;

public class SignInViewModel extends ViewModel{
    private UserRepository mRepository;
    private User mUser=new User();

    public SignInViewModel(UserRepository repository) {
        mRepository = repository;
    }

    public void afterTextChangeUsername(Editable editable){
        mUser.setUsername(editable.toString());
    }

    public void afterEmailChangeUsername(Editable editable){
        mUser.setEmail(editable.toString());
    }

    private void postUser(){
        mRepository.postUser(mUser);
    }

    public void onSignBtnClickListener(){
        postUser();
    }

    public boolean resultPost(){
        return mRepository.resultPost();
    }

}
