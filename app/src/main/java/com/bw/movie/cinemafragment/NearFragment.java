package com.bw.movie.cinemafragment;
/*
 *@auther:段海涛
 *@Date: 2020-04-27
 *@Time:15:12
 *@Description:${DESCRIPTION}
 **/

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.adapter.cinemaadapter.NearAdapter;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.bean.NearBean;
import com.bw.movie.contract.NearContract;
import com.bw.movie.presenter.NearPresenterImpl;

import java.util.List;

import butterknife.BindView;

public class NearFragment extends BaseFragment<NearPresenterImpl> implements NearContract.View {
    @BindView(R.id.near_rv)
    RecyclerView nearRv;

    @Override
    protected NearPresenterImpl initPresenter() {
        return new NearPresenterImpl();
    }

    @Override
    protected void initView(View inflate) {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        nearRv.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected int initLayout() {
        return R.layout.near_fragment;
    }

    @Override
    protected void initData() {
        presenter.near(13828,"158864475113513828",1,10);
    }

    @Override
    public void success(Object obj) {
        if (obj instanceof NearBean) {
            NearBean nearBean = (NearBean) obj;
            List<NearBean.ResultBean> result = nearBean.getResult();
            NearAdapter adapter = new NearAdapter(result,getContext());
            nearRv.setAdapter(adapter);
        }
    }

    @Override
    public void filter(String msg) {

    }
}
