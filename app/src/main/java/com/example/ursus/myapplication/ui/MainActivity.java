package com.example.ursus.myapplication.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.ursus.myapplication.R;
import com.example.ursus.myapplication.net.RestClient;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {

    @Inject
    RestClient mRestClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent().inject(this);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FooActivity.class));
            }
        });

        mRestClient.foo();
    }
}
