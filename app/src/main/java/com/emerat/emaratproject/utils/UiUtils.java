package com.emerat.emaratproject.utils;

import android.content.Context;
import android.widget.Toast;

public class UiUtils {
    private Context mContext;

    public UiUtils(Context context) {
        mContext=context.getApplicationContext();
    }

    public  void createToast(String msg){
        Toast.makeText(mContext,msg,Toast.LENGTH_LONG).show();
    }

    public  void createToast(int msgRes){
        Toast.makeText(mContext,msgRes,Toast.LENGTH_LONG).show();
    }
}
