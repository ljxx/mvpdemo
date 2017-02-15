package com.example.ylx.mainfragment.model.model;

import android.text.TextUtils;
import android.widget.Toast;

import com.example.ylx.api.ApiUtils;
import com.example.ylx.base.BaseModel;
import com.example.ylx.mainfragment.presenter.presenterdao.InformationPresenter;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * ========================================
 * <p/>
 * 版 权：蓝吉星讯 版权所有 （C） 2017
 * <p/>
 * 作 者：yanglixiang
 * <p/>
 * 版 本：1.0
 * <p/>
 * 创建日期：上午11:12 11:12
 * <p/>
 * 描 述：业务具体处理，包括负责存储、检索、操纵数据等
 * <p/>
 * 修订历史：
 * <p/>
 * ========================================
 */
public class InformationModel extends BaseModel<InformationPresenter> {

    public InformationModel(InformationPresenter iPresenter) {
        super(iPresenter);
    }

    public void loadJoke(String page) {
        if (TextUtils.isEmpty(page)) {
            mIPresenter.checkData("页数不能为空");
            return;
        }
        int iPage = Integer.valueOf(page).intValue();
        if (iPage <= 0) {
            mIPresenter.checkData("只能输入大于0的页数");
            return;
        }
        ApiUtils.loadJoke(page)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RepoJoke>() {
                               @Override
                               public void onSubscribe(Disposable d) {

                               }

                               @Override
                               public void onNext(RepoJoke repoJoke) {
                                   RepoJoke r = repoJoke;
                                   if (repoJoke == null || repoJoke.getResult() == null
                                           || repoJoke.getResult().getData() == null
                                           || repoJoke.getResult().getData().size() <= 0) {
                                       mIPresenter.showEmpty();
                                   } else {
                                       mIPresenter.showData(repoJoke.getResult().getData());
                                   }
                               }

                               @Override
                               public void onError(Throwable e) {
                                   e.printStackTrace();
                               }

                               @Override
                               public void onComplete() {

                               }
                           }

                        /*new Action1<RepoJoke>() {
                    @Override
                    public void call(RepoJoke repoJoke) {
                        if (repoJoke == null || repoJoke.getResult() == null
                                || repoJoke.getResult().getData() == null
                                || repoJoke.getResult().getData().size() <= 0) {
                            mIPresenter.showEmpty();
                        } else {
                            mIPresenter.showData(repoJoke.getResult().getData());
                        }
                    }
                }*/);
    }
}
