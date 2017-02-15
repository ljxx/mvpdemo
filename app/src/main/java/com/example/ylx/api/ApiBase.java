package com.example.ylx.api;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * ========================================
 * 描 述：网络接口请求基类
 * <p/>
 * 修订历史：
 * <p/>
 * ========================================
 */
public class ApiBase {

    protected static IApiService getService() {
        return getService(null);
    }

    protected static IApiService getService(String ip) {
        return getService(ip, 0, 0);
    }

    protected static IApiService getService(String ip, long readTime, long connectTime) {
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(readTime <= 0 ? 30 : readTime, TimeUnit.SECONDS)
                .connectTimeout(connectTime <= 0 ? 30 : connectTime, TimeUnit.SECONDS)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ip == null ? "http://api.juheapi.com" : ip)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(IApiService.class);
    }
}
