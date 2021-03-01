package com.emerat.emaratproject.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.emerat.emaratproject.model.Country;
import com.emerat.emaratproject.retrofit.RetrofitInstance;
import com.emerat.emaratproject.retrofit.RetrofitInterface;
import com.emerat.emaratproject.retrofit.gsonDeserializer.CountryListDeserializer;
import com.emerat.emaratproject.utils.ProgramUtils;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class CountryRepository {
    private static CountryRepository sInstance;
    private RetrofitInterface mRetrofitInterface;
    private List<Country> mCountryList=new ArrayList<>();

    private MutableLiveData<Boolean> mIsReceive=new MutableLiveData<>();

    private CountryRepository(RetrofitInterface retrofitInterface) {
        mRetrofitInterface=retrofitInterface;
    }

    public static CountryRepository getInstance(RetrofitInterface retrofitInterface) {
        if (sInstance==null)
            sInstance=new CountryRepository(retrofitInterface);
        return sInstance;
    }

    public void requestToReceiveCountries(){
        mRetrofitInterface= RetrofitInstance.getRetrofit(new TypeToken<List<Country>>(){}.getType(),new CountryListDeserializer()).create(RetrofitInterface.class);
        Observable<List<Country>> observable=mRetrofitInterface.getCountryList();

        observable.subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(this::setCountryList, e-> Log.e(ProgramUtils.TAG,e.getMessage()));
    }

    public void setCountryList(List<Country> countryList) {
        mCountryList = countryList;
        mIsReceive.setValue(true);
    }

    public List<Country> getCountryList() {
        return mCountryList;
    }

    public LiveData<Boolean> getIsReceive() {
        return mIsReceive;
    }
}
