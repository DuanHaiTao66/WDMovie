package com.bw.movie.fragmentlist;
/*
 *@auther:段海涛
 *@Date: 2020-04-24
 *@Time:14:39
 *@Description:${DESCRIPTION}
 **/

import android.annotation.SuppressLint;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.adapter.listadapter.GGAdapter;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.bean.GGBean;
import com.bw.movie.contract.GGContract;
import com.bw.movie.presenter.GGPresenterImpl;

import java.util.List;

import butterknife.BindView;

public class GGFragment extends BaseFragment<GGPresenterImpl> implements GGContract.View {
    @BindView(R.id.gg_rv)
    RecyclerView ggRv;

    @Override
    protected GGPresenterImpl initPresenter() {
        return new GGPresenterImpl();
    }

    @SuppressLint("WrongConstant")
    @Override
    protected void initView(View inflate) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        ggRv.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected int initLayout() {
        return R.layout.gglist_layout;
    }

    @Override
    protected void initData() {
        presenter.gg(1,5);
    }

    @Override
    public void ggSuccess(Object obj) {
        if (obj instanceof GGBean) {
            GGBean ggBean = (GGBean) obj;
            List<GGBean.ResultBean> result = ggBean.getResult();
            GGAdapter adapter = new GGAdapter(result,getContext());
            ggRv.setAdapter(adapter);
        }
    }

    @Override
    public void ggFilter(String msg) {

    }
}
