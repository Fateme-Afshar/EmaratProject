package com.emerat.emaratproject.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.emerat.emaratproject.R;
import com.emerat.emaratproject.databinding.ActivityMainBinding;
import com.emerat.emaratproject.view.fragment.AddNoticeFragment;
import com.emerat.emaratproject.view.fragment.ChatFragment;
import com.emerat.emaratproject.view.fragment.SignInFragment;
import com.emerat.emaratproject.view.fragment.SpecialNoticeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mBinding;

    public static void start(Context context) {
        Intent starter = new Intent(context, MainActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setupBottomNavigation();

        getSupportFragmentManager().
                beginTransaction().
                add(R.id.fragment_container,SpecialNoticeFragment.newInstance()).
                commit();
    }

    private void setupBottomNavigation() {
        mBinding.bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        setFragment(SpecialNoticeFragment.newInstance());
                        return true;
                    case R.id.menu_add_notice:
                        setFragment(AddNoticeFragment.newInstance());
                        return true;
                    case R.id.menu_chat:
                        setFragment(ChatFragment.newInstance());
                        return true;
                    case R.id.menu_account:
                        setFragment(SignInFragment.newInstance());
                        return true;
                    default:
                        return false;
                }
            }
        });
    }

    private void setFragment(Fragment fragment) {
            getSupportFragmentManager().
                    beginTransaction().
                    replace(R.id.fragment_container,fragment).
                    commit();
    }

}