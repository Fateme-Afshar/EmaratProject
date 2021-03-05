package com.emerat.emaratproject;

import android.app.Application;
import android.app.usage.NetworkStats;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import com.emerat.emaratproject.di.ApplicationContainer;

public class EmaratProjectApplication extends Application {
    private final ApplicationContainer mApplicationContainer=new ApplicationContainer();

    public  ApplicationContainer getApplicationContainer() {
        return mApplicationContainer;
    }
}
