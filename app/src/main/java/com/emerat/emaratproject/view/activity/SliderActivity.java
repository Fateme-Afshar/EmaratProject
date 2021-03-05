package com.emerat.emaratproject.view.activity;

import androidx.fragment.app.Fragment;

import com.emerat.emaratproject.R;
import com.emerat.emaratproject.view.fragment.SearchNoticeFragment;
import com.emerat.emaratproject.view.fragment.SliderFragment;
import com.emerat.emaratproject.view.fragment.SpecialNoticeFragment;
import com.emerat.emaratproject.view.fragment.SplashScreenFragment;

public class SliderActivity extends SingleFragmentActivity
        implements SliderFragment.SliderFragmentCallback,
        SearchNoticeFragment.SearchNoticeFragmentCallback ,
        SplashScreenFragment.SplashScreenFragmentCallback{

    @Override
    public int getLayout() {
        return R.layout.activity_slider;
    }

    @Override
    protected Fragment getFragment() {
        return SplashScreenFragment.newInstance();
    }

    @Override
    public void onStartBtnClickListener() {
        getSupportFragmentManager().
                beginTransaction().
                replace(R.id.fragment_container, SearchNoticeFragment.newInstance()).
                commit();
    }

    @Override
    public void onDataReceive() {
        MainActivity.start(this);
    }

    @Override
    public void showSliderPage() {
        getSupportFragmentManager().
                beginTransaction().
                replace(R.id.fragment_container, SliderFragment.newInstance()).
                commit();
    }
}