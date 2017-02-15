package com.example.ylx.api;

import com.example.ylx.mainfragment.model.model.RepoJoke;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * ========================================
 * 描 述：网络接口请求服务类
 * <p/>
 * 修订历史：
 * <p/>
 * ========================================
 */
public interface IApiService {

    /** 查询历史的今天
     * @param map
     * @return
     */
   /* @GET("/japi/toh")
    Observable<RepoHistory> searchHistory(@QueryMap Map<String, String> map);*/

    /** 加载笑话列表
     * @param map
     * @return
     */
    @GET("/joke/content/list.from")
    Observable<RepoJoke> loadJoke(@QueryMap Map<String, String> map);
}
