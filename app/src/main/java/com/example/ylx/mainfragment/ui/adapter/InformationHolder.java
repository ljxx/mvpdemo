package com.example.ylx.mainfragment.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.ylx.R;
import com.example.ylx.mainfragment.model.bean.InformationBean;

/**
 * ========================================
 * <p/>
 * 版 权：蓝吉星讯 版权所有 （C） 2017
 * <p/>
 * 作 者：yanglixiang
 * <p/>
 * 版 本：1.0
 * <p/>
 * 创建日期：下午2:53 14:53
 * <p/>
 * 描 述：
 * <p/>
 * 修订历史：
 * <p/>
 * ========================================
 */
public class InformationHolder extends RecyclerView.ViewHolder {

    private TextView tv_title, tv_content;

    public InformationHolder(View itemView) {
        super(itemView);
        //初始化view
        tv_title = (TextView) itemView.findViewById(R.id.tv_title);
        tv_content = (TextView) itemView.findViewById(R.id.tv_content);
    }

    /**
     * 负责更新数据，也是更新UI
     * @param mBean
     */
    public void bindData(InformationBean mBean){
        tv_title.setText(mBean.getHashId());
        tv_content.setText(mBean.getContent());
    }
}
