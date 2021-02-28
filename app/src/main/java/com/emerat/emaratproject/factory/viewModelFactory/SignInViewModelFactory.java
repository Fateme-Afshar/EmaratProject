package com.emerat.emaratproject.factory.viewModelFactory;

import com.emerat.emaratproject.factory.Factory;
import com.emerat.emaratproject.repository.UserRepository;
import com.emerat.emaratproject.viewModel.SignInViewModel;

public class SignInViewModelFactory implements Factory<SignInViewModel> {
    private UserRepository mUserRepository;

    public SignInViewModelFactory(UserRepository userRepository) {
        mUserRepository = userRepository;
    }

    @Override
    public SignInViewModel create() {
        return new SignInViewModel(mUserRepository);
    }
}
