package com.example.ursus.myapplication.injection;

import com.example.ursus.myapplication.ui.BaseActivity;
import com.example.ursus.myapplication.ui.FooActivity;
import com.example.ursus.myapplication.ui.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ursus on 25-Apr-17.
 */

@Singleton
@Component(modules = DefaultModule.class)
public interface DefaultComponent {
    void inject(MainActivity mainActivity);
    void inject(FooActivity fooActivity);
	void inject(BaseActivity baseActivity);
}
