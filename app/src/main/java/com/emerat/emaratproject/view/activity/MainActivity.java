package com.emerat.emaratproject.view.activity;

import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;

import com.emerat.emaratproject.R;
import com.emerat.emaratproject.view.fragment.ProfileFragment;
import com.emerat.emaratproject.view.fragment.SearchNoticeFragment;
import com.emerat.emaratproject.view.fragment.SignInFragment;
import com.emerat.emaratproject.view.fragment.SpecialNoticeFragment;
import com.emerat.emaratproject.view.fragment.SplashScreenFragment;

public class MainActivity extends SingleFragmentActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, MainActivity.class);
        context.startActivity(starter);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected Fragment getFragment() {
        return SpecialNoticeFragment.newInstance();
    }
}