package com.example.ylx.mainfragment.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ylx.R;
import com.example.ylx.mainfragment.model.bean.InformationBean;
import com.example.ylx.mainfragment.presenter.presenterdao.InformationPresenter;

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
 * 创建日期：下午2:09 14:09
 * <p/>
 * 描 述：
 * <p/>
 * 修订历史：
 * <p/>
 * ========================================
 */
public class InformationAdapter extends RecyclerView.Adapter<InformationHolder> {

    private List<InformationBean> mList;

    public InformationAdapter(List<InformationBean> list) {
        this.mList = list;
    }

    public void setList(List<InformationBean> mList){
        this.mList = mList;
    }

    @Override
    public InformationHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //从parent得到Context，没必要再传一个Context参数
        //这里的父布局参数是null
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.holder_item_joke, null);

        return new InformationHolder(itemView);
    }

    /**
     * 一旦创建填充满屏幕的item之后，在滑动item就会复用
     * 也就是不再调用onCreateViewHolder而是调用onBindViewHolder
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(InformationHolder holder, int position) {
        //用控制器控制数据
        holder.bindData(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
