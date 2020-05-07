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
import com.bw.movie.adapter.listadapter.HotAdapter;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.bean.HotBean;
import com.bw.movie.contract.HotContract;
import com.bw.movie.presenter.HotPresenterImpl;

import java.util.List;

import butterknife.BindView;

public class HotFragment extends BaseFragment<HotPresenterImpl>implements HotContract.View {
    @BindView(R.id.hot_rv)
    RecyclerView hotRv;


    @Override
    protected HotPresenterImpl initPresenter() {
        return new HotPresenterImpl();
    }

    @SuppressLint("WrongConstant")
    @Override
    protected void initView(View inflate) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        hotRv.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected int initLayout() {
        return R.layout.hotlist_layout;
    }

    @Override
    protected void initData() {
        presenter.hot(1,5);
    }

    @Override
    public void hotSuccess(Object obj) {
        if (obj instanceof HotBean){
            HotBean hotBean = (HotBean) obj;
            List<HotBean.ResultBean> result = hotBean.getResult();
            HotAdapter adapter = new HotAdapter(result,getContext());
            hotRv.setAdapter(adapter);
        }
    }

    @Override
    public void hotFilter(String msg) {

    }
}
