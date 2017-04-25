package com.example.ursus.myapplication.injection;

import com.example.ursus.myapplication.Dao;
import com.example.ursus.myapplication.net.Parser;
import com.example.ursus.myapplication.net.RestClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ursus on 25-Apr-17.
 */

@Module
public class NetworkModule {

    @Provides @Singleton
    public RestClient provideRestClient(Parser parser, Dao dao) {
        return new RestClient(parser, dao);
    }

    @Provides
    public Parser providerParser() {
        return new Parser();
    }
}
