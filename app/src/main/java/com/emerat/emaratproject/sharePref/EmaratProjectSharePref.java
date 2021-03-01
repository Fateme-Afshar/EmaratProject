package com.emerat.emaratproject.sharePref;

import android.content.Context;
import android.content.SharedPreferences;

import com.emerat.emaratproject.model.User;
import com.google.gson.Gson;

public class EmaratProjectSharePref {
    public static final String KEY_USER="userLogin";
    public static User sUser=new User();

    public static void saveUser(Context context, User user){
        sUser=user;
        String userInfo=new Gson().toJson(user);
        getSharePreferences(context.getApplicationContext()).
                edit().putString(KEY_USER,userInfo).apply();
    }

    public static User getUser(Context context){
        String json=getSharePreferences(context).getString(KEY_USER,null);
        return new Gson().fromJson(json,User.class);
    }

    public static SharedPreferences getSharePreferences(Context context){
        return context.getSharedPreferences("com.emerat.emaratproject",Context.MODE_PRIVATE);
    }
}
