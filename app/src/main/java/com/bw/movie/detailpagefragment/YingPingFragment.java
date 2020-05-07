package com.bw.movie.detailpagefragment;
/*
 *@auther:段海涛
 *@Date: 2020-04-25
 *@Time:16:15
 *@Description:${DESCRIPTION}
 **/

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.adapter.detailadapter.PingAdapter;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.bean.PingBean;
import com.bw.movie.contract.PingContract;
import com.bw.movie.presenter.PingPresenterImpl;

import java.util.List;

import butterknife.BindView;

public class YingPingFragment extends BaseFragment<PingPresenterImpl> implements PingContract.View {
    @BindView(R.id.yingping_rv)
    RecyclerView yingpingRv;

    @Override
    protected PingPresenterImpl initPresenter() {
        return new PingPresenterImpl();
    }

    @Override
    protected void initView(View inflate) {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        yingpingRv.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected int initLayout() {
        return R.layout.ying_ping_fragment;
    }

    @Override
    protected void initData() {
        presenter.ping(13828,"158786905715113828",24,1,5);
    }

    @Override
    public void success(Object obj) {
        if (obj instanceof PingBean) {
            PingBean pingBean = (PingBean) obj;
            List<PingBean.ResultBean> result = pingBean.getResult();
            PingAdapter adapter = new PingAdapter(result, getContext());
            yingpingRv.setAdapter(adapter);
        }
    }

    @Override
    public void filter(String msg) {

    }
}
