package com.example.ursus.myapplication.net;

import android.util.Log;

import com.example.ursus.myapplication.Dao;

import javax.inject.Inject;

/**
 * Created by ursus on 25-Apr-17.
 */

public class RestClient {

    private final Parser mParser;
    private final Dao mDao;

    @Inject
	public RestClient(Parser parser, Dao dao) {
		mParser = parser;
		mDao = dao;
	}

    public void foo() {
        Log.d("Default", "this=" + this + " mParser=" + mParser + " mDao=" + mDao);
    }
}
