package com.emerat.emaratproject.factory.viewModelFactory;

import com.emerat.emaratproject.factory.Factory;
import com.emerat.emaratproject.repository.UserRepository;
import com.emerat.emaratproject.viewModel.ProfileViewModel;

public class ProfileViewModelFactory implements Factory<ProfileViewModel> {
    private UserRepository mUserRepository;

    public ProfileViewModelFactory(UserRepository userRepository) {
        mUserRepository = userRepository;
    }

    @Override
    public ProfileViewModel create() {
        return null;
    }
}
