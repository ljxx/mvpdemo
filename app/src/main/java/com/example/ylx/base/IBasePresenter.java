package com.example.ylx.base;

/**
 * ========================================
 * 描 述：presenter的接口基类 View和Model的桥梁，它从Model层检索数据后，返回给View层
 * <p/>
 * 修订历史：
 * <p/>
 * ========================================
 */
public interface IBasePresenter<V extends IBaseView> {

    /**绑定接口*/
    void attachView(V view);

    /**释放接口*/
    void detachView();

}
