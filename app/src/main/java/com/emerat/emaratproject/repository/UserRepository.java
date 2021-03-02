package com.emerat.emaratproject.repository;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.emerat.emaratproject.model.PostResponse;
import com.emerat.emaratproject.model.User;
import com.emerat.emaratproject.retrofit.RetrofitInterface;
import com.emerat.emaratproject.sharePref.EmaratProjectSharePref;
import com.emerat.emaratproject.utils.ProgramUtils;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class UserRepository {
    private static UserRepository sInstance;
    private final RetrofitInterface mRetrofitInterface;
    private MutableLiveData<PostResponse> mIsPost=new MutableLiveData<>();
    private MutableLiveData<Boolean> mIsEdit=new MutableLiveData<>();

    private PostResponse mPostResponse=new PostResponse();

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

    public void editUser(User user){
        Observable<PostResponse> observable=mRetrofitInterface.editUser(user);

        observable.subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(this::setResultPostUser, e-> Log.e(ProgramUtils.TAG,e.getMessage()));
    }

    public void setResultEditUser(PostResponse postResponse){
        mIsEdit.setValue(!postResponse.equals(null));
    }

    public void setResultPostUser(PostResponse postResponse){
        mIsPost.setValue(postResponse);
        Log.d(ProgramUtils.TAG,postResponse.getToken());
    }

    public LiveData<Boolean> resultEdit() {
        return mIsEdit;
    }

    public LiveData<PostResponse> resultPost(){
       return mIsPost;
    }
}
