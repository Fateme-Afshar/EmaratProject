package com.emerat.emaratproject.networkObserver;

import android.app.Application;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

public class NetworkObserverLiveData extends LiveData<Boolean> {
    private NetworkObserverLiveData sInstance;
    private Application mApplication;
    private NetworkRequest mNetworkRequest;

    private NetworkObserverLiveData(){

    }

    public NetworkObserverLiveData getsInstance() {
        if (sInstance==null)
            sInstance=new NetworkObserverLiveData();
        return sInstance;
    }

    @Override
    protected void onActive() {
        super.onActive();
        getDetails();
    }

    public void init(Application application){
        mApplication=application;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mNetworkRequest=new NetworkRequest.Builder().
                    addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR).
                    addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
                    .build();
        }
    }

    private void getDetails(){
        ConnectivityManager connectivityManager= null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            connectivityManager = mApplication.getSystemService(ConnectivityManager.class);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            connectivityManager.registerNetworkCallback(mNetworkRequest,new ConnectivityManager.NetworkCallback(){
                @Override
                public void onAvailable(@NonNull Network network) {
                    super.onAvailable(network);
                    postValue(true);
                }

                @Override
                public void onUnavailable() {
                    super.onUnavailable();
                    postValue(false);
                }

                @Override
                public void onLost(@NonNull Network network) {
                    super.onLost(network);
                    postValue(false);
                }
            });
        }
    }
}
