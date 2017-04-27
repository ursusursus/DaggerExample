package com.example.ursus.myapplication.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.ursus.myapplication.R;
import com.example.ursus.myapplication.net.RestClient;

import javax.inject.Inject;

/**
 * Created by ursus on 25-Apr-17.
 */

public class FooActivity extends BaseActivity {

    @Inject
    RestClient mRestClient;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foo);
        getComponent().inject(this);

        mRestClient.foo();
    }
}
