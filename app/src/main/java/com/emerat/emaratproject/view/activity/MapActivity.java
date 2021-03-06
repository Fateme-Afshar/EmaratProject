package com.emerat.emaratproject.view.activity;

import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;

import com.emerat.emaratproject.R;
import com.emerat.emaratproject.view.fragment.MapFragment;

public class MapActivity extends SingleFragmentActivity {
    public static void start(Context context) {
        Intent starter = new Intent(context, MapActivity.class);
        //starter.putExtra();
        context.startActivity(starter);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_map;
    }

    @Override
    protected Fragment getFragment() {
        return MapFragment.newInstance();
    }
}