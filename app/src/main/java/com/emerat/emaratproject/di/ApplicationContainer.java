package com.emerat.emaratproject.di;

import com.emerat.emaratproject.factory.viewModelFactory.SignInViewModelFactory;
import com.emerat.emaratproject.repository.UserRepository;
import com.emerat.emaratproject.retrofit.RetrofitInstance;
import com.emerat.emaratproject.retrofit.RetrofitInterface;

public class ApplicationContainer {
    private RetrofitInterface mRetrofitInstance=
            RetrofitInstance.getInstance().getRetrofit().create(RetrofitInterface.class);
    private UserRepository mUserRepository=UserRepository.getInstance(mRetrofitInstance);

    private SignInViewModelFactory mSignInViewModelFactory=
            new SignInViewModelFactory(mUserRepository);

    public SignInViewModelFactory getSignInViewModelFactory() {
        return mSignInViewModelFactory;
    }

    public  UserRepository getUserRepository(){
        return UserRepository.getInstance(mRetrofitInstance);
    }

}
