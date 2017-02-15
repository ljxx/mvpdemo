package com.example.ylx.api;

import com.example.ylx.mainfragment.model.model.RepoJoke;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;

/**
 * ========================================
 * 描 述：网络接口请求工具类
 * <p/>
 * 修订历史：
 * <p/>
 * ========================================
 */
public class ApiUtils extends ApiBase {

    /*public static Observable<RepoHistory> searchHistory(String month, String day) {
        Map<String, String> map = new HashMap<>();
        map.put("key", "7ac7e02ff7f1f8f1ccdc2f9e5dddb6be");
        map.put("v", "1.0");
        map.put("month", month);
        map.put("day", day);
        return getService().searchHistory(map);
    }*/

    public static Observable<RepoJoke> loadJoke(String page) {
        Map<String, String> map = new HashMap<>();
        map.put("key", "d796a03545bddee0b56d913111f5f199");
        map.put("sort", "asc");
        map.put("time", "1418745237");
        map.put("page", page);
        map.put("pagesize", "10");
        return getService().loadJoke(map);
    }
}
