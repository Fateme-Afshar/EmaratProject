package com.emerat.emaratproject.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.emerat.emaratproject.model.data.Notice;
import com.emerat.emaratproject.model.data.ResponseProduct;
import com.emerat.emaratproject.retrofit.RetrofitInterface;
import com.emerat.emaratproject.utils.NetworkUtils;
import com.emerat.emaratproject.utils.ProgramUtils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class NoticeRepository {
    private static NoticeRepository sInstance;
    private RetrofitInterface mRetrofitInterface;

    private List<Notice> mNotices =new ArrayList<>();

    private MutableLiveData<Boolean> mIsReceiveProduct=new MutableLiveData<>();

    private NoticeRepository(RetrofitInterface retrofitInterface) {
        mRetrofitInterface = retrofitInterface;
    }

    public static NoticeRepository getInstance(RetrofitInterface retrofitInterface) {
        if (sInstance == null)
            sInstance = new NoticeRepository(retrofitInterface);
        return sInstance;
    }

    public void requestServerReceiveProducts(String countryId, String cityId) {
       Observable<ResponseProduct> observable =
                mRetrofitInterface.getDataItem(NetworkUtils.createMap(countryId,cityId));

/*        Observable<ResponseProduct> observable=mRetrofitInterface.getAllProduct();*/

        observable.subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(this::setNotices, t -> Log.e(ProgramUtils.TAG,t.getMessage()));
    }

    public void setNotices(ResponseProduct responseProduct){
        mNotices.addAll(responseProduct.getNoticeList());
        mIsReceiveProduct.setValue(true);
    }

    public List<Notice> getNotices() {
        return mNotices;
    }

    public LiveData<Boolean> getIsReceiveProduct() {
        return mIsReceiveProduct;
    }
}
