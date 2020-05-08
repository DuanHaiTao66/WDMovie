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
import com.bw.movie.adapter.cinemadetailadapter.CinemaEvaluateAdapter;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.bean.CinemaEvaluateBean;
import com.bw.movie.contract.CinemaEvaluateContract;
import com.bw.movie.presenter.CinemaEvaluatePresenterImpl;

import java.util.List;

import butterknife.BindView;

public class CinemaEvaluateFragment extends BaseFragment<CinemaEvaluatePresenterImpl> implements CinemaEvaluateContract.View {

    @BindView(R.id.rv)
    RecyclerView rv;

    @Override
    protected CinemaEvaluatePresenterImpl initPresenter() {
        return new CinemaEvaluatePresenterImpl();
    }

    @Override
    protected void initView(View inflate) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        rv.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected int initLayout() {
        return R.layout.cinema_evaluate_fragment;
    }

    @Override
    protected void initData() {
        presenter.cinemaEvaluate(13828,"158892006050613828",1,1,5);
    }

    @Override
    public void success(Object obj) {
        if (obj instanceof CinemaEvaluateBean) {
            CinemaEvaluateBean cinemaEvaluateBean = (CinemaEvaluateBean) obj;
            List<CinemaEvaluateBean.ResultBean> result = cinemaEvaluateBean.getResult();
            CinemaEvaluateAdapter adapter = new CinemaEvaluateAdapter(result, getContext());
            rv.setAdapter(adapter);
        }
    }

    @Override
    public void filter(String msg) {

    }
}
