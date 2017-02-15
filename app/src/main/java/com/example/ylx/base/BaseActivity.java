package com.example.ylx.base;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by yanglixiang on 2017/2/14.
 */

public class BaseActivity extends Activity {

    /**
     * 跳转activity
     */
    public void jumpActivity(Class<?> clazz){
        Intent mIntent = new Intent(this, clazz);
        startActivity(mIntent);
    }
}
