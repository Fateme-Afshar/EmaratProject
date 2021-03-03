package com.emerat.emaratproject.view.activity;

import androidx.fragment.app.Fragment;

import com.emerat.emaratproject.R;
import com.emerat.emaratproject.view.fragment.ProfileFragment;
import com.emerat.emaratproject.view.fragment.SearchNoticeFragment;
import com.emerat.emaratproject.view.fragment.SignInFragment;
import com.emerat.emaratproject.view.fragment.SpecialNoticeFragment;

public class MainActivity extends SingleFragmentActivity
        implements SearchNoticeFragment.SearchNoticeFragmentCallback {

    @Override
    protected Fragment getFragment() {
        return SearchNoticeFragment.newInstance();
    }

    @Override
    public void onDataReceive() {
        getSupportFragmentManager().
                beginTransaction().
                replace(R.id.fragment_container,SpecialNoticeFragment.newInstance()).
                commit();
    }
}