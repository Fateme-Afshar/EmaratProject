package com.emerat.emaratproject;

import android.app.Application;

import com.emerat.emaratproject.di.ApplicationContainer;

public class EmaratProjectApplication extends Application {
    private final ApplicationContainer mApplicationContainer=new ApplicationContainer();

    public  ApplicationContainer getApplicationContainer() {
        return mApplicationContainer;
    }
}
