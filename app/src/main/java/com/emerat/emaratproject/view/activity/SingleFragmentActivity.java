package com.emerat.emaratproject.view.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.emerat.emaratproject.R;

public abstract class SingleFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());

        Fragment fragment=getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (fragment==null)
            getSupportFragmentManager().
                    beginTransaction().
                    add(R.id.fragment_container,getFragment()).
                    commit();
    }

    public abstract int getLayout();

    protected abstract Fragment getFragment();
}
