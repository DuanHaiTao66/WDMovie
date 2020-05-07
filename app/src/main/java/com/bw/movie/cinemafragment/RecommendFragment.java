package com.bw.movie.cinemafragment;
/*
 *@auther:段海涛
 *@Date: 2020-04-27
 *@Time:15:09
 *@Description:${DESCRIPTION}
 **/

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.adapter.cinemaadapter.RecommendAdapter;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.bean.RecommendBean;
import com.bw.movie.contract.RecommendContract;
import com.bw.movie.presenter.RecommendPresenterImpl;

import java.util.List;

import butterknife.BindView;

public class RecommendFragment extends BaseFragment<RecommendPresenterImpl> implements RecommendContract.View {
    @BindView(R.id.recommend_rv)
    RecyclerView recommendRv;

    @Override
    protected RecommendPresenterImpl initPresenter() {
        return new RecommendPresenterImpl();
    }

    @Override
    protected void initView(View inflate) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recommendRv.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected int initLayout() {
        return R.layout.recommend_fragment;
    }

    @Override
    protected void initData() {
        presenter.recommend(13828,"158582945095913828",1,10);
    }

    @Override
    public void success(Object obj) {
        if (obj instanceof RecommendBean) {
            RecommendBean recommendBean = (RecommendBean) obj;
            List<RecommendBean.ResultBean> result = recommendBean.getResult();
            RecommendAdapter adapter = new RecommendAdapter(result,getContext());
            recommendRv.setAdapter(adapter);
        }
    }

    @Override
    public void filter(String msg) {

    }
}
