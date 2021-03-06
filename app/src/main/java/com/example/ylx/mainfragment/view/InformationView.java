package com.example.ylx.mainfragment.view;

import com.example.ylx.base.IBaseView;
import com.example.ylx.mainfragment.model.bean.InformationBean;

import java.util.List;

/**
 * Created by yanglixiang on 2017/2/15.
 * UI界面抽象出来的接口
 */

public interface InformationView extends IBaseView {
    /**
     * 显示数据
     */
    void showData(List<InformationBean> list);

    /**
     * 无数据
     */
    void showEmpty();

    /**
     * 数据检测提示
     */
    void checkData(String msg);
}
