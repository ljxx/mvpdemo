package com.example.ylx.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * ========================================
 * 描 述：mvp activity基类
 * <p/>
 * 修订历史：
 * <p/>
 * ========================================
 */
public abstract class BaseMVPFragment<V extends IBaseView, P extends IBasePresenter<V>> extends
        BaseFragment implements IBaseDelegate<V, P> {

    protected P mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
    }

    @NonNull
    @Override
    public P getPresenter(){
        return mPresenter;
    }

    @Override
    public void onDestroy() {
        mPresenter.detachView();
        super.onDestroy();
    }
}
