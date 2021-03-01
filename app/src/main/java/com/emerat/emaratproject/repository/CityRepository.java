package com.emerat.emaratproject.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.emerat.emaratproject.model.City;
import com.emerat.emaratproject.retrofit.RetrofitInterface;
import com.emerat.emaratproject.utils.ProgramUtils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class CityRepository {
    private static CityRepository sInstance;
    private RetrofitInterface mRetrofitInterface;

    private List<City> mCityList=new ArrayList<>();
    private MutableLiveData<Boolean> mIsReceiveCity=new MutableLiveData<>();

    private CityRepository(RetrofitInterface retrofitInterface){
        mRetrofitInterface=retrofitInterface;
    }

    public static CityRepository getInstance(RetrofitInterface retrofitInterface) {
        if (sInstance==null)
            sInstance=new CityRepository(retrofitInterface);
        return sInstance;
    }

    public void requestServerReceiveCities(String countryCode){
        Observable<List<City>> observable=mRetrofitInterface.getCityList(countryCode);

        observable.subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(this::setCityList,t -> Log.e(ProgramUtils.TAG, t.getMessage()));
    }

    public void setCityList(List<City> cityList) {
        mCityList = cityList;
        mIsReceiveCity.setValue(true);
    }

    public List<City> getCityList() {
        return mCityList;
    }

    public LiveData<Boolean> getIsReceiveCity() {
        return mIsReceiveCity;
    }
}
