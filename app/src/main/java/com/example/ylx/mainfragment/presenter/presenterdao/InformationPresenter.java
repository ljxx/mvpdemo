package com.example.ylx.mainfragment.presenter.presenterdao;

import com.example.ylx.mainfragment.model.bean.InformationBean;

import java.util.List;

/**
 * Created by yanglixiang on 2017/2/15.
 * 此接口作用是连接Model
 */

public interface InformationPresenter {

    /**
     * 显示数据
     */
    void showData(List<InformationBean> list);

    /**
     * 提示无数据
     */
    void showEmpty();

    /**
     * 数据检测提示
     */
    void checkData(String msg);

}
