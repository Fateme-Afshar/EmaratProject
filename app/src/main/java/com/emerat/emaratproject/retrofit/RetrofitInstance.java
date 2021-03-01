package com.emerat.emaratproject.retrofit;

import com.emerat.emaratproject.utils.NetworkUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;

import okhttp3.OkHttpClient;
import retrofit2.Converter;
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

    public static Retrofit getRetrofit(Type type, Object typeAdapter) {
        return new Retrofit.Builder().
                baseUrl(NetworkUtils.BASE_URL).
                addConverterFactory(createConverterFactoryCustom(type,typeAdapter)).
                addCallAdapterFactory(RxJava2CallAdapterFactory.create()).
                build();
    }

    private static Converter.Factory createConverterFactoryCustom(Type type, Object typeAdapter){
        GsonBuilder gsonBuilder=new GsonBuilder();
        gsonBuilder.registerTypeAdapter(type,typeAdapter);

        Gson gson=gsonBuilder.create();

        return GsonConverterFactory.create(gson);
    }
}
