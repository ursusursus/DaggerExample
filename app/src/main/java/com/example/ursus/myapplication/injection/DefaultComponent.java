package com.example.ursus.myapplication.injection;

import com.example.ursus.myapplication.FooActivity;
import com.example.ursus.myapplication.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ursus on 25-Apr-17.
 */

@Singleton
@Component(modules = NetworkModule.class)
public interface DefaultComponent {
    void inject(MainActivity mainActivity);
    void inject(FooActivity fooActivity);
}
