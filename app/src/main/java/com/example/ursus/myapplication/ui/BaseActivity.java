package com.example.ursus.myapplication.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.ursus.myapplication.App;
import com.example.ursus.myapplication.Dao;
import com.example.ursus.myapplication.injection.DefaultComponent;

import javax.inject.Inject;

/**
 * Created by ursus on 25-Apr-17.
 */

public abstract class BaseActivity extends AppCompatActivity {

	@Inject Dao mDao;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getComponent().inject(this);
		Log.d("Default", "mDao=" + mDao);
	}

	protected DefaultComponent getComponent() {
        return ((App) getApplication()).getComponent();
    }
}
