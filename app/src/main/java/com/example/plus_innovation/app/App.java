package com.example.plus_innovation.app;

import android.app.Application;

import com.example.plus_innovation.di.AppComponent;
import com.example.plus_innovation.di.DaggerAppComponent;

public class App extends Application {
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .application(this)
                .build();

    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
