package com.emerat.emaratproject.utils;

import android.content.Context;
import android.widget.Toast;

public class UiUtils {

    public static void createToast(Context context,String msg){
        Toast.makeText(context,msg,Toast.LENGTH_LONG).show();
    }

    public static void createToast(Context context,int msgRes){
        Toast.makeText(context,msgRes,Toast.LENGTH_LONG).show();
    }
}
