package com.emerat.emaratproject.view.activity;

import androidx.fragment.app.Fragment;

import com.emerat.emaratproject.view.fragment.ProfileFragment;
import com.emerat.emaratproject.view.fragment.SearchNoticeFragment;
import com.emerat.emaratproject.view.fragment.SignInFragment;

public class MainActivity extends SingleFragmentActivity {

    @Override
    protected Fragment getFragment() {
        return SearchNoticeFragment.newInstance();
    }
}