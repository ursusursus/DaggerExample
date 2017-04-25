package com.example.ursus.myapplication;

import android.support.v7.app.AppCompatActivity;

import com.example.ursus.myapplication.injection.DefaultComponent;

/**
 * Created by ursus on 25-Apr-17.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected DefaultComponent getCompontent() {
        return ((App) getApplication()).getComponent();
    }
}
