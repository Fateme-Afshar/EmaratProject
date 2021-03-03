package com.emerat.emaratproject.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.emerat.emaratproject.model.anything.DataItem;
import com.emerat.emaratproject.model.anything.ResponseProduct;
import com.emerat.emaratproject.retrofit.RetrofitInterface;
import com.emerat.emaratproject.utils.NetworkUtils;
import com.emerat.emaratproject.utils.ProgramUtils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataRepository {
    private static DataRepository sInstance;
    private RetrofitInterface mRetrofitInterface;

    private List<DataItem> mDataItems =new ArrayList<>();

    private MutableLiveData<Boolean> mIsReceiveProduct=new MutableLiveData<>();

    private DataRepository(RetrofitInterface retrofitInterface) {
        mRetrofitInterface = retrofitInterface;
    }

    public static DataRepository getInstance(RetrofitInterface retrofitInterface) {
        if (sInstance == null)
            sInstance = new DataRepository(retrofitInterface);
        return sInstance;
    }

    public void requestServerReceiveProducts(String countryId, String cityId) {
       Observable<ResponseProduct> observable =
                mRetrofitInterface.getDataItem(NetworkUtils.createMap(countryId,cityId));

/*        Observable<ResponseProduct> observable=mRetrofitInterface.getAllProduct();*/

        observable.subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(this::setDataItems, t -> Log.e(ProgramUtils.TAG,t.getMessage()));
    }

    public void setDataItems(ResponseProduct responseProduct){
        mDataItems.addAll(responseProduct.getData());
        mIsReceiveProduct.setValue(true);
    }

    public List<DataItem> getDataItems() {
        return mDataItems;
    }

    public LiveData<Boolean> getIsReceiveProduct() {
        return mIsReceiveProduct;
    }
}
