package com.example.ursus.myapplication.injection;

import com.example.ursus.myapplication.Dao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ursus on 25-Apr-17.
 */

@Module
public class DataModule {

    @Provides
    @Singleton
    public Dao provideDao() {
        return new Dao();
    }
}
