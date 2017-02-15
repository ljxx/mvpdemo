package com.example.ylx.base;

import android.os.Bundle;
import android.support.annotation.NonNull;

/**
 * ========================================
 * 描 述：mvp activity基类
 * <p/>
 * 修订历史：
 * <p/>
 * ========================================
 */
public abstract class BaseMVPActivity<V extends IBaseView, P extends IBasePresenter<V>> extends
        BaseActivity implements IBaseDelegate<V, P> {

    protected P mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
    }

    @NonNull
    @Override
    public P getPresenter() {
        return mPresenter;
    }

    @Override
    protected void onDestroy() {
        mPresenter.detachView();
        super.onDestroy();
    }
}
