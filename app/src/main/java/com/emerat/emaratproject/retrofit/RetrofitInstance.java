package com.emerat.emaratproject.retrofit;

import com.emerat.emaratproject.utils.NetworkUtils;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private static RetrofitInstance sInstance;

    private RetrofitInstance() {
    }

    public static RetrofitInstance getInstance() {
        if (sInstance==null)
            sInstance=new RetrofitInstance();
        return sInstance;
    }

    public Retrofit getRetrofit(){
        return new Retrofit.Builder().
                baseUrl(NetworkUtils.BASE_URL).
                addConverterFactory(GsonConverterFactory.create()).
                addCallAdapterFactory(RxJava2CallAdapterFactory.create()).
                build();
    }
}
