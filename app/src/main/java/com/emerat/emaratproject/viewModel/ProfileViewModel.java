package com.emerat.emaratproject.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.emerat.emaratproject.model.User;
import com.emerat.emaratproject.repository.UserRepository;
import com.emerat.emaratproject.sharePref.EmaratProjectSharePref;

public class ProfileViewModel extends AndroidViewModel {
    private UserRepository mUserRepository;

    public ProfileViewModel(@NonNull Application application,UserRepository userRepository) {
        super(application);
        mUserRepository=userRepository;
    }


    public User getUser(){
       return EmaratProjectSharePref.getUser(getApplication());
    }
}
