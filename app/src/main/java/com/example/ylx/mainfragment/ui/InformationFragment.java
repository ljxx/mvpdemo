package com.example.ylx.mainfragment.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.ylx.R;
import com.example.ylx.base.BaseFragment;
import com.example.ylx.base.BaseMVPFragment;
import com.example.ylx.home.ui.MainActivity;
import com.example.ylx.mainfragment.model.bean.InformationBean;
import com.example.ylx.mainfragment.presenter.presenterdao.InformationPresenter;
import com.example.ylx.mainfragment.presenter.presenterimpl.InformationPresenterImpl;
import com.example.ylx.mainfragment.ui.adapter.InformationAdapter;
import com.example.ylx.mainfragment.view.InformationView;
import com.example.ylx.other.EndlessRecyclerOnScrollListener;

import java.util.ArrayList;
import java.util.List;

public class InformationFragment extends BaseMVPFragment<InformationView, InformationPresenterImpl> implements InformationView {

    private EditText etPage;
    private RecyclerView mRecyclerView;
    private LinearLayout llEmpty, llLoading;
    private InformationAdapter mAdapter;
    private Button btn_load;

    private List<InformationBean> mDataList;
    private LinearLayoutManager mLiearLayoutManager;

    @Override
    protected int inflateView() {
        return R.layout.fragment_information;
    }

    @Override
    protected void initView() {
        etPage = (EditText) mView.findViewById(R.id.et_page);
        llEmpty = (LinearLayout) mView.findViewById(R.id.ll_empty);
        llLoading = (LinearLayout) mView.findViewById(R.id.ll_loading);
        btn_load = (Button) mView.findViewById(R.id.btn_load);
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.mRecyclerView);

        mDataList = new ArrayList<InformationBean>();
        mLiearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLiearLayoutManager);// 布局管理器,一定要设置布局，否则不会显示
        mRecyclerView.addItemDecoration(new DividerItemDecoration(
                getActivity(), DividerItemDecoration.VERTICAL)); //设置分割线
        mRecyclerView.setHasFixedSize(true);// 如果Item够简单，高度是确定的，打开FixSize将提高性能。
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());// 设置Item默认动画，加也行，不加也行。
        mAdapter = new InformationAdapter(mDataList);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void initListen() {
        btn_load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mPage = etPage.getText().toString().trim();
                System.out.println("=========点击加载了====Page====" + mPage);
                getPresenter().loadJoke(mPage);
            }
        });

        /**
         * 上啦加载更多
         */
        mRecyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener(mLiearLayoutManager) {
            @Override
            public void onLoadMore(int currentPage) {
                System.out.println("=========点击加载了====currentPage====" + currentPage);
                etPage.setText(currentPage+"");
                getPresenter().loadJoke(String.valueOf(currentPage));
            }
        });
    }


    @NonNull
    @Override
    public InformationPresenterImpl createPresenter() {
        return new InformationPresenterImpl(this);
    }

    @Override
    public void showData(List<InformationBean> list) {
        llEmpty.setVisibility(View.GONE);
        mDataList.addAll(list);
        mAdapter.setList(mDataList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showEmpty() {
        String mPage = etPage.getText().toString().trim();
        if(mPage.equals("1")){
            llEmpty.setVisibility(View.VISIBLE);
        } else {
            llEmpty.setVisibility(View.GONE);
        }
    }

    @Override
    public void checkData(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showLoading() {
        String mPage = etPage.getText().toString().trim();
        if(mPage.equals("1")){
            llLoading.setVisibility(View.VISIBLE);
        } else {
            llLoading.setVisibility(View.GONE);
        }
    }

    @Override
    public void dismiss() {
        llLoading.setVisibility(View.GONE);
    }
}
