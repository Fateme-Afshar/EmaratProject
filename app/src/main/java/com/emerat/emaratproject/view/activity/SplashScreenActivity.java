package com.emerat.emaratproject.view.activity;

import androidx.fragment.app.Fragment;

import com.emerat.emaratproject.view.fragment.SplashScreenFragment;

public class SplashScreenActivity extends SingleFragmentActivity{

    @Override
    protected Fragment getFragment() {
        return SplashScreenFragment.newInstance();
    }
}
