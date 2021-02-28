package com.emerat.emaratproject;

import android.app.Application;

import com.emerat.emaratproject.di.ApplicationContainer;

public class EmaratProjectApplication extends Application {
    private static ApplicationContainer mApplicationContainer=new ApplicationContainer();

    public static ApplicationContainer getApplicationContainer() {
        return mApplicationContainer;
    }
}
