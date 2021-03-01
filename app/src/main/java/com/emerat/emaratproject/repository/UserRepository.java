package com.emerat.emaratproject.repository;

import android.annotation.SuppressLint;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.emerat.emaratproject.model.Country;
import com.emerat.emaratproject.model.PostResponse;
import com.emerat.emaratproject.model.User;
import com.emerat.emaratproject.retrofit.RetrofitInterface;
import com.emerat.emaratproject.utils.ProgramUtils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class UserRepository {
    private static UserRepository sInstance;
    private final RetrofitInterface mRetrofitInterface;
    private MutableLiveData<Boolean> mIsPost=new MutableLiveData<>();

    private UserRepository(RetrofitInterface retrofitInterface) {
        mRetrofitInterface= retrofitInterface;
    }

    public static UserRepository getInstance(RetrofitInterface retrofitInterface) {
        if (sInstance==null)
            sInstance=new UserRepository(retrofitInterface);
        return sInstance;
    }

    @SuppressLint("CheckResult")
    public void postUser(User user){
        Observable<PostResponse> observable=mRetrofitInterface.postUser(user);

       observable.subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(this::setResultPostUser, e-> Log.e(ProgramUtils.TAG,e.getMessage()));
    }

    public void setResultPostUser(PostResponse isPost){
        mIsPost.setValue(!isPost.equals(null));
    }

    public LiveData<Boolean> resultPost(){
       return mIsPost;
    }
}
