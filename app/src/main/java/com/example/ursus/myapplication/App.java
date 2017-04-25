package com.example.ursus.myapplication;

import android.app.Application;

import com.example.ursus.myapplication.injection.DaggerDefaultComponent;
import com.example.ursus.myapplication.injection.DefaultComponent;
import com.example.ursus.myapplication.injection.NetworkModule;

/**
 * Created by ursus on 25-Apr-17.
 */

public class App extends Application {

    private DefaultComponent mComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mComponent = DaggerDefaultComponent.builder()
                .defaultModule(new NetworkModule())
                .build();
    }

    public DefaultComponent getComponent() {
        return mComponent;
    }
}
