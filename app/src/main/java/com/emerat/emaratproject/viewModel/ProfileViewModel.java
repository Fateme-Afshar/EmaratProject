package com.emerat.emaratproject.viewModel;

import androidx.lifecycle.ViewModel;

import com.emerat.emaratproject.repository.UserRepository;

public class ProfileViewModel extends ViewModel {
    private UserRepository mUserRepository;

    public ProfileViewModel(UserRepository userRepository) {
        mUserRepository = userRepository;
    }


}
