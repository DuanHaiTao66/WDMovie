package com.bw.movie.cinemafragment;
/*
 *@auther:段海涛
 *@Date: 2020-04-27
 *@Time:15:14
 *@Description:${DESCRIPTION}
 **/

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.Event;
import com.bw.movie.R;
import com.bw.movie.adapter.cinemaadapter.LeftAdapter;
import com.bw.movie.adapter.cinemaadapter.RightAdapter;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.bean.LeftBean;
import com.bw.movie.bean.RightBean;
import com.bw.movie.contract.RegionContract;
import com.bw.movie.presenter.RegionPresenterImpl;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import butterknife.BindView;

public class RegionFragment extends BaseFragment<RegionPresenterImpl> implements RegionContract.View {
    @BindView(R.id.left_rv)
    RecyclerView leftRv;
    @BindView(R.id.right_rv)
    RecyclerView rightRv;

    @Override
    protected RegionPresenterImpl initPresenter() {
        return new RegionPresenterImpl();
    }

    @Override
    protected void initView(View inflate) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        leftRv.setLayoutManager(linearLayoutManager);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext());
        linearLayoutManager1.setOrientation(RecyclerView.VERTICAL);
        rightRv.setLayoutManager(linearLayoutManager1);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this);
        }
    }

    @Override
    protected int initLayout() {
        return R.layout.region_fragment;
    }

    @Subscribe
    public void ThreadMain(Event event){
        int id = event.id;
        presenter.right(id);
    }

    @Override
    protected void initData() {
        presenter.left();
        presenter.right(1);
    }

    @Override
    public void leftSuccess(Object obj) {
        if (obj instanceof LeftBean){
            LeftBean leftBean = (LeftBean) obj;
            List<LeftBean.ResultBean> result = leftBean.getResult();
            LeftAdapter adapter = new LeftAdapter(result,getContext());
            leftRv.setAdapter(adapter);
        }
    }

    @Override
    public void leftFilter(String msg) {

    }

    @Override
    public void rightSuccess(Object obj) {
        if (obj instanceof RightBean){
            RightBean rightBean = (RightBean) obj;
            List<RightBean.ResultBean> result = rightBean.getResult();
            RightAdapter adapter = new RightAdapter(result,getContext());
            rightRv.setAdapter(adapter);
        }
    }

    @Override
    public void rightFilter(String msg) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
