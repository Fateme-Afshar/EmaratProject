package com.emerat.emaratproject.repository;

import android.annotation.SuppressLint;
import android.util.Log;

import com.emerat.emaratproject.model.User;
import com.emerat.emaratproject.retrofit.RetrofitInstance;
import com.emerat.emaratproject.retrofit.RetrofitInterface;
import com.emerat.emaratproject.utils.ProgramUtils;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class UserRepository {
    private static UserRepository sInstance;
    private final RetrofitInterface mRetrofitInterface;
    private boolean mIsPost;

    private UserRepository(RetrofitInterface retrofitInterface) {
        mRetrofitInterface= retrofitInterface;
        //RetrofitInstance.getInstance().getRetrofit().create(RetrofitInterface.class);
    }

    public static UserRepository getInstance(RetrofitInterface retrofitInterface) {
        if (sInstance==null)
            sInstance=new UserRepository(retrofitInterface);
        return sInstance;
    }

    @SuppressLint("CheckResult")
    public void postUser(User user){
        Observable<Boolean> observable=mRetrofitInterface.postUser(user);
        observable.subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(this::setResultPostUser, e-> Log.e(ProgramUtils.TAG,e.getMessage()));
    }

    public void setResultPostUser(boolean isPost){
        mIsPost=isPost;
    }

    public boolean resultPost(){
       return mIsPost;
    }
}
