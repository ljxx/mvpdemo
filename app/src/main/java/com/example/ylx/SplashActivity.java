package com.example.ylx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ylx.base.BaseActivity;
import com.example.ylx.home.ui.MainActivity;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        try {
            Thread.sleep(2000);
            jumpActivity(MainActivity.class);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
