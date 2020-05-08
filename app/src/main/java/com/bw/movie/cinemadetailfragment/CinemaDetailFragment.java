package com.bw.movie.cinemadetailfragment;
/*
 *@auther:段海涛
 *@Date: 2020-05-08
 *@Time:15:06
 *@Description:${DESCRIPTION}
 **/


import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.adapter.cinemadetailadapter.CinemaDetailAdapter;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.bean.CinemaDetailBean;
import com.bw.movie.contract.CinemaDetailContract;
import com.bw.movie.presenter.CinemaDetailPresenterImpl;

import java.util.List;

import butterknife.BindView;

public class CinemaDetailFragment extends BaseFragment<CinemaDetailPresenterImpl> implements CinemaDetailContract.View {

    @BindView(R.id.rv)
    RecyclerView rv;

    @Override
    protected CinemaDetailPresenterImpl initPresenter() {
        return new CinemaDetailPresenterImpl();
    }

    @Override
    protected void initView(View inflate) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        rv.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected int initLayout() {
        return R.layout.cinema_detail_fragment;
    }

    @Override
    protected void initData() {
        presenter.cinemaDetail(13828 ,"158892006050613828",5);
    }

    @Override
    public void success(Object obj) {
        if (obj instanceof CinemaDetailBean) {
            CinemaDetailBean cinemaDetailBean = (CinemaDetailBean) obj;
            CinemaDetailBean.ResultBean result = cinemaDetailBean.getResult();
            CinemaDetailAdapter adapter = new CinemaDetailAdapter(result,getContext());
            rv.setAdapter(adapter);
        }
    }

    @Override
    public void filter(String msg) {

    }
}
