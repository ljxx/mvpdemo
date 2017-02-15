package com.example.ylx.mainfragment.presenter.presenterimpl;

import com.example.ylx.base.IBasePresenter;
import com.example.ylx.mainfragment.model.bean.InformationBean;
import com.example.ylx.mainfragment.model.model.InformationModel;
import com.example.ylx.mainfragment.presenter.presenterdao.InformationPresenter;
import com.example.ylx.mainfragment.view.InformationView;

import java.util.List;

/**
 * ========================================
 * <p/>
 * 版 权：蓝吉星讯 版权所有 （C） 2017
 * <p/>
 * 作 者：yanglixiang
 * <p/>
 * 版 本：1.0
 * <p/>
 * 创建日期：上午11:14 11:14
 * <p/>
 * 描 述：
 * <p/>
 * 修订历史：
 * <p/>
 * ========================================
 */
public class InformationPresenterImpl implements IBasePresenter<InformationView>, InformationPresenter {

    private InformationView mView;
    private InformationModel mModel;

    public InformationPresenterImpl(InformationView view){
        attachView(view);
        mModel = new InformationModel(this);
    }

    @Override
    public void showData(List<InformationBean> list) {
        mView.dismiss();
        mView.showData(list);
    }

    @Override
    public void showEmpty() {
        mView.dismiss();
        mView.showEmpty();
    }

    @Override
    public void checkData(String msg) {
        mView.checkData(msg);
    }

    @Override
    public void attachView(InformationView view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        this.mView = null;
    }

    public void loadJoke(String page){
        System.out.println("========Page====" + page);
        if(mModel == null){
            System.out.println("=====Model===null====");
        }
        mView.showLoading();
        mModel.loadJoke(page);
    }
}
