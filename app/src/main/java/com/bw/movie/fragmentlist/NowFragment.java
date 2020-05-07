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
import com.bw.movie.adapter.listadapter.NowAdapter;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.bean.NowBean;
import com.bw.movie.contract.NowContract;
import com.bw.movie.presenter.NowPresenterImpl;

import java.util.List;

import butterknife.BindView;

public class NowFragment extends BaseFragment<NowPresenterImpl> implements NowContract.View {


    @BindView(R.id.now_rv)
    RecyclerView nowRv;

    @Override
    protected NowPresenterImpl initPresenter() {
        return new NowPresenterImpl();
    }

    @SuppressLint("WrongConstant")
    @Override
    protected void initView(View inflate) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        nowRv.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected int initLayout() {
        return R.layout.nowlist_layout;
    }

    @Override
    protected void initData() {
        presenter.now(1,5);
    }

    @Override
    public void nowSuccess(Object obj) {
        if (obj instanceof NowBean) {
            NowBean nowBean = (NowBean) obj;
            List<NowBean.ResultBean> result = nowBean.getResult();
            NowAdapter adapter = new NowAdapter(result,getContext());
            nowRv.setAdapter(adapter);
        }
    }

    @Override
    public void nowFilter(String msg) {

    }
}
